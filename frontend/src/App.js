import React, { useState, useEffect } from 'react';
import { Routes, Route, Link } from "react-router-dom";
import './App.css';
import "bootstrap/dist/css/bootstrap.min.css"

import AuthService from './services/auth.service';

import Login from './components/Login';
import Register from './components/Register';
import Home from './components/Home';
import Profile from './components/Profile';
import BoardUser from './components/BoardUser';
import BoardAdmin from './components/BoardAdmin';

const App = () => {
  const [showAdminBoard, setShowAdminBoard] = useState(false);
  const [showUserBoard, setShowUserBoard] = useState(false);
  const [currentUser, setCurrentUser] = useState(undefined);

  useEffect(() => {
    const user = AuthService.getCurrentUser();

    if (user) {
      setCurrentUser(user);
      setShowAdminBoard(user.roles.includes("ROLE_ADMIN"));
      setShowUserBoard(user.roles.includes("ROLES_USER"));
    }
  }, [])

  const logout = () => {
    AuthService.logout();
  };

  return(
    <div>
      <nav className='navbar navbar-expand navbar-dark bg-dark'>
        <Link to={"/"}  className="navbar-brand">
          Formación BB2
        </Link>
        <div className='navbar-nav mr-auto'>
          <li className='nav-item'>
            <Link to={"/home"} className="nav-link">
              Home
            </Link>
          </li>
          {showAdminBoard && (
            <li className='nav-item'>
              <Link to={"/admin"} className="nav-link">
                Admin Board
              </Link>
            </li>
          )}
          {showUserBoard && (
            <li className='nav-item'>
              <Link to={"/user"} className="nav-link">
                User Board
              </Link>
            </li>
          )}
          </div>
          {currentUser ? (
            <div className='navbar-nav ml-auto'>
              <li className='nav-item'>
                <Link to={"/profile"} className="nav-link">
                  {currentUser.username}
                </Link>
              </li>
              <li className='nav-item'>
                <a href='/login' className='nav-link' onClick={logout}>
                  logOut
                </a>
              </li>
            </div>
          ):(
            <div className='navbar navbar-ml-auto'>
              <li className='nav-item'>
                <Link to={"/login"} className="nav-link">
                  Login
                </Link>
              </li>
              <li className='nav-item'>
                <Link to={"/register"} className="nav-link">
                  Sign Up
                </Link>
              </li>
            </div>
          )}
      </nav>
      
      <div className='container mt-3'>
        <Routes>
          <Route path="/" element={<Home/>} />
          <Route path="/home" element={<Home/>} />
          <Route path="/login" element={<Login/>} />
          <Route path="/register" element={<Register/>} />
          <Route path="/profile" element={<Profile/>} />
          <Route path="/user" element={<BoardUser/>} />
          <Route path="/admin" element={<BoardAdmin/>} />
        </Routes>
      </div>
    </div>
  )
}

export default App;
