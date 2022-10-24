
import React, { useEffect, useMemo, useRef, useState } from "react";
import ItemDataService from "../services/item.service";
import { useTable } from "react-table";
import AddItem from "./AddItem";
import { useDispatch, useSelector } from "react-redux";
import { createItem } from "../slices/item";

const ItemsList = (props) => {
    const [Items, setItems] = useState([]);

    const initialItemState = {
        itemCode: "",
        description: "",
        priceItem: "",
        stateItem: ""
    };



    const [newItem, setNewItem] = useState(initialItemState);
    const [submitted, setSubmitted] = useState(false);

    const dispatch = useDispatch();

    const { message } = useSelector((state) => state.message);


    const ItemsRef = useRef();

    ItemsRef.current = Items;

    useEffect(() => {
        retrieveItems();
    }, []);


    const retrieveItems = () => {
        ItemDataService.getAll()
            .then((response) => {
                console.log('ItemList: ', response.data)
                setItems(response.data);
            })
            .catch((e) => {
                console.log(e);
            });
    };

    const refreshList = () => {
        retrieveItems();
    };

    const saveItem = () => {
         const { itemCode, description, priceItem } = newItem;

         console.log('MIAUUU',{itemCode, description, priceItem })
         dispatch(createItem(newItem))
         .unwrap()
         .then(data => {
                 setItems({
                     itemCode: data.itemCode,
                     description: data.description,
                     priceItem: data.priceItem,
                    //  stateItem: data.stateItem
                 });
                 setSubmitted(true);
             })
             .catch(e => {
                 console.log(e);
             })
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


    const openItem = (rowIndex) => {
        const id = ItemsRef.current[rowIndex].id;

        props.history.push("/Item/" + id);
    };

    const deleteItem = (rowIndex) => {
        const id = ItemsRef.current[rowIndex].id;

        ItemDataService.remove(id)
            .then((response) => {
                props.history.push("/Item");

                let newItems = [...ItemsRef.current];
                newItems.splice(rowIndex, 1);

                setItems(newItems);
            })
            .catch((e) => {
                console.log(e);
            });
    };

    const handleInputChange = event => {
        const { name, value } = event.target;
        setNewItem({ ...newItem, [name]: value });
    };

    const columns = useMemo(
        () => [
            {
                Header: "Item Code",
                accessor: "itemCode",
            },
            {
                Header: "Description",
                accessor: "description",
            },
            {
                Header: "Price",
                accessor: "priceItem",
            },
            {
                Header: "Creation Date",
                accessor: "creationDateItem",
            },
            {
                Header: "ID Creator",
                accessor: "idCreatorItem",
            },
            {
                Header: "State",
                accessor: "stateItems",
                Cell: (props) => {
                    return props.value && props.value === true ? "Active" : "Discontinued";
                }
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
            <div className="submit-form ">

                <div className="col-md-8 list">
                    <div className="input-group mb-3">
                        <input
                            type="text"
                            className="form-control"
                            id="itemCode"
                            placeholder="Item Code"
                            required
                            value={newItem.itemCode}
                            onChange={handleInputChange}
                            name="itemCode"
                        />
                        <input
                            type="text"
                            className="form-control"
                            id="description"
                            required
                            placeholder="Description"
                            value={newItem.description}
                            onChange={handleInputChange}
                            name="description"
                        />
                        <input
                            type="text"
                            className="form-control"
                            id="priceItem"
                            placeholder="Price"
                            value={newItem.priceItem}
                            onChange={handleInputChange}
                            name="priceItem"
                        />
                        {/* <input
                            type="text"
                            className="form-control"
                            id="stateItem"
                            placeholder="State"
                            value={newItem.stateItem}
                            onChange={handleInputChange}
                            name="stateItem"
                        /> */}
                        <div className="input-group-append">
                            <button
                                className="btn btn-outline-secondary"
                                type="button"
                                onClick={saveItem}
                            // onClick={AddItem}
                            >
                                New Item
                            </button>
                        </div>
                    </div>
                </div>
                {submitted && (
                    <div className="form-group">
                        <div
                            className={submitted ? "alert alert-success" : "alert alert-danger"}
                            role="alert"
                        >
                            {message}
                            {setSubmitted(false)}
                        </div>
                    </div>
                )}
            </div>
            <div>

            </div>
            <br />
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