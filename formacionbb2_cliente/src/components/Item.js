import React, { useEffect, usestatusItem } from "react";
import ItemDataService from "../services/item.service";

const Item = props => {
    const initialItemstatusItem = {
        idItem: null,
        itemCode: "",
        description: "",
        priceItem: "",
        creationDate: "",
        idCreatorItem: "",
        stateItems: "",
        statusItem: false
    };
    const [currentItem, setCurrentItem] = usestatusItem(initialItemstatusItem);
    const [message, setMessage] = usestatusItem("");

    const getItem = idItem => {
        ItemDataService.get(idItem)
            .then(response => {
                setCurrentItem(response.data);
                console.log('Item: ', response.data);
            })
            .catch(e => {
                console.log(e);
            });
    };

    useEffect(() => {
        getItem(props.match.params.idItem);
    }, [props.match.params.idItem]);

    const handleInputChange = event => {
        const { name, value } = event.target;
        setCurrentItem({ ...currentItem, [name]: value });
    };

    const updatestateItem = status => {


        let data = {
            idItem: currentItem.idItem,
            itemCode: currentItem.itemCode,
            description: currentItem.description,
            priceItem: currentItem.priceItem,
            creationDateItem: currentItem.creationDateItem,
            idCreatorItem: currentItem.idCreatorItem,
            stateItems: currentItem.stateItems+' ',
            // statusItem: status
        };

        ItemDataService.update(currentItem.idItem, data)
            .then(response => {
                setCurrentItem({ ...currentItem, statesItem: currentItem.stateItems });
                console.log(response.data);
                setMessage("The state was updated successfully!");
            })
            .catch(e => {
                console.log(e);
            });
    };

    const updateItem = () => {
        ItemDataService.update(currentItem.idItem, currentItem)
            .then(response => {
                console.log(response.data);
                setMessage("The Item was updated successfully!");
            })
            .catch(e => {
                console.log(e);
            });
    };

    const deleteItem = () => {
        ItemDataService.remove(currentItem.idItem)
            .then(response => {
                console.log(response.data);
                props.history.push("/Items");
            })
            .catch(e => {
                console.log(e);
            });
    };

    return (
        <div>
            {currentItem ? (
                <div className="edit-form">
                    <h4>Item</h4>
                    <form>
                        <div className="form-group">
                            <label htmlFor="itemCode">Item Code</label>
                            <input
                                type="text"
                                className="form-control"
                                idItem="itemCode"
                                name="itemCode"
                                value={currentItem.itemCode}
                                onChange={handleInputChange}
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="description">Description</label>
                            <input
                                type="text"
                                className="form-control"
                                idItem="description"
                                name="description"
                                value={currentItem.description}
                                onChange={handleInputChange}
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="priceItem">Price</label>
                            <input
                                type="text"
                                className="form-control"
                                idItem="priceItem"
                                name="priceItem"
                                value={currentItem.priceItem}
                                onChange={handleInputChange}
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="creationDateItem">Creation Date</label>
                            <input
                                type="text"
                                className="form-control"
                                idItem="creationDateItem"
                                name="creationDateItem"
                                value={currentItem.creationDateItem}
                                onChange={handleInputChange}
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="idCreatorItem">item idCreatorItem</label>
                            <input
                                type="text"
                                className="form-control"
                                idItem="idCreatorItem"
                                name="idCreatorItem"
                                value={currentItem.idCreatorItem}
                                onChange={handleInputChange}
                            />
                        </div>
                            <div className="form-group">
                                <label htmlFor="stateItems">stateItems</label>
                                <input
                                    type="text"
                                    className="form-control"
                                    idItem="stateItems"
                                    name="stateItems"
                                    value={currentItem.stateItems+' '}
                                    onChange={handleInputChange}
                                />
                            </div>
                    </form>

                    {currentItem.statusItem ? (
                        <button
                            className="badge badge-primary mr-2"
                            onClick={() => updatestateItem(false)}
                        >
                            Discontinued
                        </button>
                    ) : (
                        <button
                            className="badge badge-primary mr-2"
                            onClick={() => updatestateItem(true)}
                        >
                            Active
                        </button>
                    )}

                    <button className="badge badge-danger mr-2" onClick={deleteItem}>
                        Delete
                    </button>

                    <button
                        type="submit"
                        className="badge badge-success"
                        onClick={updateItem}
                    >
                        Update
                    </button>
                    <p>{message}</p>
                </div>
            ) : (
                <div>
                    <br />
                    <p>Please click on a Item...</p>
                </div>
            )}
        </div>
    );
};

export default Item;