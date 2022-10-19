import React, { Component } from "react";
import { connect } from "react-redux";
import { Routes, Route, Link, HashRouter } from "react-router-dom";

import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

import Login from "./components/login.component";
import Register from "./components/register.component";
import Home from "./components/home.component";
import Profile from "./components/profile.component";
import BoardUser from "./components/boardUser.component";
import BoardAdmin from "./components/boardAdmin.component";

import { logout } from "./actions/auth.js";
import { clearMessage } from "./actions/messages.js";

import { history } from './helpers/history.js';

class App extends Component {
  constructor(props) {
    super(props);
    this.logOut = this.logOut.bind(this);

    this.state = {
      showAdminBoard: false,
      currentUser: undefined,
    };

    history.listen((location) => {
      props.dispatch(clearMessage()); // clear message when changing location
    });
  }

  componentDidMount() {
    const user = this.props.user;

    if (user) {
      this.setState({
        currentUser: user,
        showAdminBoard: user.roles.includes("ROLE_ADMIN"),
      });
    }
  }

  logOut() {
    this.props.dispatch(logout());
  }

  render() {
    const { currentUser, showAdminBoard } = this.state;

    return (
      <HashRouter history={history}>
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
                  <Link to={"/user"} className="nav-link">
                    User
                  </Link>
                </li>
              )}
            </div>

            {currentUser ? (
              <div className="navbar-nav ml-auto">
                <li className="nav-item">
                  <Link to={"/profile"} className="nav-link">
                    {currentUser.username}
                  </Link>
                </li>
                <li className="nav-item">
                  <a href="/login" className="nav-link" onClick={this.logOut}>
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
              <Route exact path="/" component={<Home />} />
              <Route exact path="/login" component={<Login />} />
              <Route exact path="/register" component={<Register />} />
              <Route exact path="/profile" component={<Profile />} />
              <Route path="/user" component={<BoardUser />} />
              <Route path="/admin" component={<BoardAdmin />} />
            </Routes>
          </div>
        </div>
      </HashRouter>
    );
  }
}

function mapStateToProps(state) {
  const { user } = state.auth;
  return {
    user,
  };
}

export default connect(mapStateToProps)(App);


// import React, { useState, useEffect } from 'react';
// import { Routes, Route, Link } from "react-router-dom";
// import './App.css';
// import "bootstrap/dist/css/bootstrap.min.css"

// import AuthService from './services/auth.service';

// import Login from './components/login';
// import Register from './components/register';
// import Home from './components/home';
// import Profile from './components/profile';
// import BoardUser from './components/boardUser';
// import BoardAdmin from './components/boardAdmin';

// const App = () => {
//   const [showAdminBoard, setShowAdminBoard] = useState(false);
//   const [showUserBoard, setShowUserBoard] = useState(false);
//   const [currentUser, setCurrentUser] = useState(undefined);

//   useEffect(() => {
//     const user = AuthService.getCurrentUser();

//     if (user) {
//       setCurrentUser(user);
//       setShowAdminBoard(user.roles.includes("ROLE_ADMIN"));
//       setShowUserBoard(user.roles.includes("ROLES_USER"));
//     }
//   }, [])

//   const logout = () => {
//     AuthService.logout();
//   };

//   return(
//     <div>
//       <nav className='navbar navbar-expand navbar-dark bg-dark'>
//         <Link to={"/test"}  className="navbar-brand">
//           Formación BB2
//         </Link>
//         <div className='navbar-nav mr-auto'>
//           <li className='nav-item'>
//             <Link to={"/home"} className="nav-link">
//               Home
//             </Link>
//           </li>
//           {showAdminBoard && (
//             <li className='nav-item'>
//               <Link to={"/admin"} className="nav-link">
//                 Admin Board
//               </Link>
//             </li>
//           )}
//           {showUserBoard && (
//             <li className='nav-item'>
//               <Link to={"/user"} className="nav-link">
//                 User Board
//               </Link>
//             </li>
//           )}
//           </div>
//           {currentUser ? (
//             <div className='navbar-nav ml-auto'>
//               <li className='nav-item'>
//                 <Link to={"/profile"} className="nav-link">
//                   {currentUser.username}
//                 </Link>
//               </li>
//               <li className='nav-item'>
//                 <a href='/login' className='nav-link' onClick={logout}>
//                   logOut
//                 </a>
//               </li>
//             </div>
//           ):(
//             <div className='navbar navbar-ml-auto'>
//               <li className='nav-item'>
//                 <Link to={"/login"} className="nav-link">
//                   Login
//                 </Link>
//               </li>
//               <li className='nav-item'>
//                 <Link to={"/register"} className="nav-link">
//                   Sign Up
//                 </Link>
//               </li>
//             </div>
//           )}
//       </nav>
      
//       <div className='container mt-3'>
//         <Routes>
//           <Route path="/" element={<Home/>} />
//           <Route path="/home" element={<Home/>} />
//           <Route path="/login" element={<Login/>} />
//           <Route path="/register" element={<Register/>} />
//           <Route path="/profile" element={<Profile/>} />
//           <Route path="/user" element={<BoardUser/>} />
//           <Route path="/admin" element={<BoardAdmin/>} />
//         </Routes>
//       </div>
//     </div>
//   )
// }

// export default App;
