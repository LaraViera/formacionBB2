import React, {useEffect, useMemo, useRef, useState} from "react";
import ItemDataService from "../services/item.service";
import {useTable} from "react-table";

const ItemsList = (props) => {
    const [Items, setItems] = useState([]);
    const [searchPrice, setSearchPrice] = useState("");
    const ItemsRef = useRef();

    ItemsRef.current = Items;

    useEffect(() => {
        retrieveItems();
    }, []);

    const onChangeSearchPrice = (e) => {
        const searchPrice = e.target.value;
        setSearchPrice(searchPrice);
    };

    const retrieveItems = () => {
        ItemDataService.getAll()
            .then((response) => {
                setItems(response.data);
            })
            .catch((e) => {
                console.log(e);
            });
    };

    const refreshList = () => {
        retrieveItems();
    };

    const removeAllItems = () => {
        ItemDataService.removeAll()
            .then((response) => {
                console.log(response.data);
                refreshList();
            })
            .catch((e) => {
                console.log(e);
            });
    };

    const findByPrice = () => {
        ItemDataService.findByPrice(searchPrice)
            .then((response) => {
                setItems(response.data);
            })
            .catch((e) => {
                console.log(e);
            });
    };

    const openItem = (rowIndex) => {
        const id = ItemsRef.current[rowIndex].id;

        props.history.push("/Items/" + id);
    };

    const deleteItem = (rowIndex) => {
        const id = ItemsRef.current[rowIndex].id;

        ItemDataService.remove(id)
            .then((response) => {
                props.history.push("/Items");

                let newItems = [...ItemsRef.current];
                newItems.splice(rowIndex, 1);

                setItems(newItems);
            })
            .catch((e) => {
                console.log(e);
            });
    };

    const columns = useMemo(
        () => [
            {
                Header: "Price",
                accessor: "price",
            },
            {
                Header: "Description",
                accessor: "description",
            },
            {
                Header: "Status",
                accessor: "published",
                Cell: (props) => {
                    return props.value ? "Published" : "Pending";
                },
            },
            {
                Header: "Actions",
                accessor: "actions",
                Cell: (props) => {
                    const rowIdx = props.row.id;
                    return (
                        <div>
              <span onClick={() => openItem(rowIdx)}>
                <i className="far fa-edit action mr-2"></i>
              </span>

                            <span onClick={() => deleteItem(rowIdx)}>
                <i className="fas fa-trash action"></i>
              </span>
                        </div>
                    );
                },
            },
        ],
        []
    );

    const {
        getTableProps,
        getTableBodyProps,
        headerGroups,
        rows,
        prepareRow,
    } = useTable({
        columns,
        data: Items,
    });

    return (
        <div className="list row">
            <div className="col-md-8">
                <div className="input-group mb-3">
                    <input
                        type="text"
                        className="form-control"
                        placeholder="Search by price"
                        value={searchPrice}
                        onChange={onChangeSearchPrice}
                    />
                    <div className="input-group-append">
                        <button
                            className="btn btn-outline-secondary"
                            type="button"
                            onClick={findByPrice}
                        >
                            Search
                        </button>
                    </div>
                </div>
            </div>
            <div className="col-md-12 list">
                <table
                    className="table table-striped table-bordered"
                    {...getTableProps()}
                >
                    <thead>
                    {headerGroups.map((headerGroup) => (
                        <tr {...headerGroup.getHeaderGroupProps()}>
                            {headerGroup.headers.map((column) => (
                                <th {...column.getHeaderProps()}>
                                    {column.render("Header")}
                                </th>
                            ))}
                        </tr>
                    ))}
                    </thead>
                    <tbody {...getTableBodyProps()}>
                    {rows.map((row, i) => {
                        prepareRow(row);
                        return (
                            <tr {...row.getRowProps()}>
                                {row.cells.map((cell) => {
                                    return (
                                        <td {...cell.getCellProps()}>{cell.render("Cell")}</td>
                                    );
                                })}
                            </tr>
                        );
                    })}
                    </tbody>
                </table>
            </div>

            <div className="col-md-8">
                <button className="btn btn-sm btn-danger" onClick={removeAllItems}>
                    Remove All
                </button>
            </div>
        </div>
    );
};

export default ItemsList;