import React, {useEffect, useState} from "react";
import ItemDataService from "../services/item.service";

const Item = props => {
    const initialItemState = {
        idItem: null,
        itemCode:"",
        description: "",
        priceItem: "",
        creationDate:"",
        creator:"",
        state: false
    };
    const [currentItem, setCurrentItem] = useState(initialItemState);
    const [message, setMessage] = useState("");

    const getItem = idItem => {
        ItemDataService.get(idItem)
            .then(response => {
                setCurrentItem(response.data);
                console.log('Item: ',response.data);
            })
            .catch(e => {
                console.log(e);
            });
    };

    useEffect(() => {
        getItem(props.match.params.idItem);
    }, [props.match.params.idItem]);

    const handleInputChange = event => {
        const {name, value} = event.target;
        setCurrentItem({...currentItem, [name]: value});
    };

    const updatestate = status => {
        let data = {
            idItem: currentItem.idItem,
            itemCode:currentItem.itemCode,
            description: currentItem.description,
            priceItem: currentItem.priceItem,
            creationDate:currentItem.creationDate,
            creator:currentItem.creator,
            state: status
        };

        ItemDataService.update(currentItem.idItem, data)
            .then(response => {
                setCurrentItem({...currentItem, state: status});
                console.log(response.data);
                setMessage("The status was updated successfully!");
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
                            <label htmlFor="creationDate">Creation Date</label>
                            <input
                                type="text"
                                className="form-control"
                                idItem="creationDate"
                                name="creationDate"
                                value={currentItem.creationDate}
                                onChange={handleInputChange}
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="creator">idItem creator</label>
                            <input
                                type="text"
                                className="form-control"
                                idItem="creator"
                                name="creator"
                                value={currentItem.creator}
                                onChange={handleInputChange}
                            />
                        </div>

                        <div className="form-group">
                            <label>
                                <strong>Status:</strong>
                            </label>
                            {currentItem.state ? "state" : "Pending"}
                        </div>
                    </form>

                    {currentItem.state ? (
                        <button
                            className="badge badge-primary mr-2"
                            onClick={() => updatestate(false)}
                        >
                            UnPublish
                        </button>
                    ) : (
                        <button
                            className="badge badge-primary mr-2"
                            onClick={() => updatestate(true)}
                        >
                            Publish
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
                    <br/>
                    <p>Please click on a Item...</p>
                </div>
            )}
        </div>
    );
};

export default Item;