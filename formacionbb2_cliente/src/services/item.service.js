/*import axios from "axios";
import authHeader from "./auth-header";
import itemHeader from "./item-header";

const API_URL = "http://localhost:8080/item/";

const getAllItems = () => {
    return axios.get(API_URL + "allItems", { headers: authHeader() });
};

const setNewItem = () => {
    return axios.get(API_URL + "saveItem", { headers: authHeader() });
  };

  const getDetailsItem = () => {
    return axios.get(API_URL + "detailItem", { headers: [itemHeader(), authHeader()] });
  };

  const setNewSupplier = () => {
    return axios.get(API_URL + "addSupplier", { headers: authHeader() });
  };

const itemService = {
    getAllItems, setNewItem, getDetailsItem, setNewSupplier
};

export default itemService;*/

import http from "../common/http-common";
import authHeader from "./auth-header";

import axios from "axios";
import itemHeader from "./item-header";
import userEvent from "@testing-library/user-event";


 const API_URL = "http://localhost:8080/item";

const getAll = () => {
  return axios.get(API_URL + "/allItems", {headers: itemHeader()  });
};


/*const getAll = () => {
  return http.get("/allItems");
};*/

const get = (id) => {
  return http.get(`/item/${id}`);
};

const create = (data) => {
  return http.post("/item", data);
};

const update = (id, data) => {
  return http.put(`/item/${id}`, data);
};

const remove = (id) => {
  return http.delete(`/item/${id}`);
};

const removeAll = () => {
  return http.delete(`/item`);
};

const findByPrice = (price) => {
  return http.get(`/item?price=${price}`);
};

const ItemService = {
  getAll,
  get,
  create,
  update,
  remove,
  removeAll,
  findByPrice,
};

export default ItemService;
