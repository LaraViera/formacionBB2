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

const getAll = () => {
  return http.get("/allItem", {headers: authHeader()});
};

const get = (id) => {
  return http.get(`/items/${id}`);
};

const create = (data) => {
  return http.post("/items", data);
};

const update = (id, data) => {
  return http.put(`/items/${id}`, data);
};

const remove = (id) => {
  return http.delete(`/items/${id}`);
};

const removeAll = () => {
  return http.delete(`/items`);
};

const findByPrice = (price) => {
  return http.get(`/items?price=${price}`);
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
