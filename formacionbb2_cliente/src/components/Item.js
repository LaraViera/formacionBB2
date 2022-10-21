import React, {useEffect, useState} from "react";
import ItemDataService from "../services/item.service";

const Item = props => {
    const initialItemState = {
        id: null,
        price: "",
        description: "",
        state: false
    };
    const [currentItem, setCurrentItem] = useState(initialItemState);
    const [message, setMessage] = useState("");

    const getItem = id => {
        ItemDataService.get(id)
            .then(response => {
                setCurrentItem(response.data);
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
    };

    useEffect(() => {
        getItem(props.match.params.id);
    }, [props.match.params.id]);

    const handleInputChange = event => {
        const {name, value} = event.target;
        setCurrentItem({...currentItem, [name]: value});
    };

    const updatestate = status => {
        var data = {
            id: currentItem.id,
            price: currentItem.price,
            description: currentItem.description,
            state: status
        };

        ItemDataService.update(currentItem.id, data)
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
        ItemDataService.update(currentItem.id, currentItem)
            .then(response => {
                console.log(response.data);
                setMessage("The Item was updated successfully!");
            })
            .catch(e => {
                console.log(e);
            });
    };

    const deleteItem = () => {
        ItemDataService.remove(currentItem.id)
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
                            <label htmlFor="price">price</label>
                            <input
                                type="text"
                                className="form-control"
                                id="price"
                                name="price"
                                value={currentItem.price}
                                onChange={handleInputChange}
                            />
                        </div>
                        <div className="form-group">
                            <label htmlFor="description">Description</label>
                            <input
                                type="text"
                                className="form-control"
                                id="description"
                                name="description"
                                value={currentItem.description}
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