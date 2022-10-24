import React, {useState} from "react";
import { useDispatch } from "react-redux";
import ItemDataService from "../services/item.service";
import { createItem } from "../slices/item";

const AddItem = () => {
    const initialItemState = {
        itemCode: "",
        description: "",
        priceItem: "",
        stateItems: ""
    };

    const [Item, setItem] = useState(initialItemState);
    const [submitted, setSubmitted] = useState(false);

    const dispatch = useDispatch();

    const handleInputChange = event => {
        const {name, value} = event.target;
        setItem({...Item, [name]: value});
    };

    const saveItem = () => {
        // let data = {
        //     itemCode:this.Item.itemCode,
        //     priceItem: this.Item.priceItem,
        //     description: this.Item.description,
        //     stateItems:this.Item.stateItems("true")
        // };

        // ItemDataService.create(data)
        //     .then(response => {
        //         setItem({
        //             itemCode: response.data.itemCode,
        //             priceItem: response.data.priceItem,
        //             description: response.data.description,
        //             stateItems: response.data.stateItems
        //         });
        //         setSubmitted(true);
        //         console.log(response.data);
        //     })
        //     .catch(e => {
        //         console.log(e);
        //     });
        const {itemCode, description, priceItem, stateItems} = newItem;
        
        dispatch(createItem({itemCode, description, priceItem, stateItems}))
        .unwrap().then(data =>{
            console.log(data);
            setItem({
                itemCode:data.itemCode,
                description:data.description,
                priceItem:data.priceItem,
                stateItems:data.stateItems
            });
            setSubmitted(true);
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