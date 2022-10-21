import React, {useState} from "react";
import ItemDataService from "../services/item.service";

const AddItem = () => {
    const initialItemState = {
        id: null,
        price: "",
        description: "",
        state: false
    };
    const [Item, setItem] = useState(initialItemState);
    const [submitted, setSubmitted] = useState(false);

    const handleInputChange = event => {
        const {name, value} = event.target;
        setItem({...Item, [name]: value});
    };

    const saveItem = () => {
        let data = {
            price: Item.price,
            description: Item.description
        };

        ItemDataService.create(data)
            .then(response => {
                setItem({
                    id: response.data.id,
                    price: response.data.price,
                    description: response.data.description,
                    state: response.data.state
                });
                setSubmitted(true);
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
    };

    const newItem = () => {
        setItem(initialItemState);
        setSubmitted(false);
    };

    return (
        <div className="submit-form">
            {submitted ? (
                <div>
                    <h4>You submitted successfully!</h4>
                    <button className="btn btn-success" onClick={newItem}>
                        Add
                    </button>
                </div>
            ) : (
                <div>
                    <div className="form-group">
                        <label htmlFor="price">price</label>
                        <input
                            type="text"
                            className="form-control"
                            id="price"
                            required
                            value={Item.price}
                            onChange={handleInputChange}
                            name="price"
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="description">Description</label>
                        <input
                            type="text"
                            className="form-control"
                            id="description"
                            required
                            value={Item.description}
                            onChange={handleInputChange}
                            name="description"
                        />
                    </div>

                    <button onClick={saveItem} className="btn btn-success">
                        Submit
                    </button>
                </div>
            )}
        </div>
    );
};

export default AddItem;