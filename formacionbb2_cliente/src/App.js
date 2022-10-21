import React, {useCallback, useEffect, useState} from 'react';
import {useDispatch, useSelector} from "react-redux";
import {BrowserRouter as Router, Link, Route, Routes} from 'react-router-dom';

import "bootstrap/dist/css/bootstrap.min.css";
import './App.css';

import Login from "./components/Login";
import Register from "./components/Register";
import Home from "./components/Home";
import Profile from "./components/Profile";
import BoardAdmin from "./components/BoardAdmin";
import Item from './components/Item';
import AddItem from './components/AddItem';
import ItemsList from './components/ItemList';

import {logout} from './slices/auth';

import eventBus from '../src/common/EventBus'

const App = () => {
  const [showAdminBoard, setShowAdminBoard] = useState(false);

  const {user: currentUser} = useSelector((state) => state.auth);
  const dispatch = useDispatch();

  const logOut = useCallback(() => {
    dispatch(logout());
  }, [dispatch]);


  useEffect(() => {
    if (currentUser) {
      setShowAdminBoard(currentUser.roles.includes("ROLE_ADMIN"));
    } else {
      setShowAdminBoard(false);
    }
    eventBus.on("logout", () => {
      logOut();
    })

    return () => {
      eventBus.remove("logout");
    };
  }, [currentUser, logOut]);


  return (
    <Router>
    <div>
      <nav className="navbar navbar-expand navbar-dark bg-dark">
        <Link to={"/"} className="navbar-brand">
          Formación BB2
        </Link>
        <div className="navbar-nav mr-auto">
          <li className="nav-item">
            <Link to={"/home"} className="nav-link">
              Home
            </Link>
          </li>

          {showAdminBoard && (
            <li className="nav-item">
              <Link to={"/admin"} className="nav-link">
                Admin Board
              </Link>
            </li>
          )}

          {currentUser && (
              <li className="nav-item">
                <Link to={"/itemList"} className="nav-link">
                  Item List
                </Link>
              </li>
          )}
        </div>

        {currentUser ? (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <Link to={"/items"} className="nav-link">
                  Items
                </Link>
              </li>
              <li className="nav-item">
                <Link to={"/add"} className="nav-link">
                  Add
                </Link>
              </li>
              <li className="nav-item">
                <Link to={"/profile"} className="nav-link">
                  {currentUser.username}
                </Link>
              </li>
              <li className="nav-item">
                <a href="/login" className="nav-link" onClick={logOut}>
                  LogOut
                </a>
              </li>

            </div>
        ) : (
          <div className="navbar-nav ml-auto">
            <li className="nav-item">
              <Link to={"/login"} className="nav-link">
                Login
              </Link>
            </li>

            <li className="nav-item">
              <Link to={"/register"} className="nav-link">
                Sign Up
              </Link>
            </li>
          </div>
        )}
      </nav>

      <div className="container mt-3">
        <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/home" element={<Home/>}/>
          <Route path="/login" element={<Login/>}/>
          <Route path="/register" element={<Register/>}/>
          <Route path="/profile" element={<Profile/>}/>
          <Route path="/itemList" element={<ItemsList/>}/>
          <Route path="/admin" element={<BoardAdmin/>}/>
          <Route path="/add" component={<AddItem/>}/>
          <Route path="/items/:id" component={<Item/>}/>
        </Routes>
      </div>
    </div>
  </Router>
  );
};

export default App;
