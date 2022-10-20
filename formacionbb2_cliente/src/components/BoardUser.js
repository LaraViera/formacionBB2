import React, { useState, useEffect } from "react";

import UserService from "../services/user.service";

// para controlar la expiración del JWT token
import eventBus from "../EventBus";

const BoardUser = () => {
    const [content, setContent] = useState("");

    useEffect(() => {
        UserService.getUserBoard().then(
            (response) => {
                setContent(response.data);
            },
            (error) => {
                const _content = (error.response && error.response.data && error.response.data.message) || error.message || error.toString();
                setContent(_content);

                // comprobamos si la respuesta es 401 y si el usuario está logueado lo sacamos
                if (error.response && error.response.status === 401){
                    eventBus.dispatch("logout");
                }
            }
        );
    }, []);

    return (
        <div className="container">
            <header className="jumbotron">
                <h3>{content}</h3>
            </header>
        </div>
    );
};
export default BoardUser;