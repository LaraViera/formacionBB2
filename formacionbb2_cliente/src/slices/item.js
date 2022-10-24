import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import ItemService from "../services/item.service";

const initialItemState = [];

export const createItem = createAsyncThunk(
    "/item/createItem",
    async({itemCode, description, priceItem }) =>{
        const res = await ItemService.create({itemCode, description, priceItem});
        return res.data;
    }
)