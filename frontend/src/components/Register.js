import React, {useState, useRef} from "react";
import {useNavigate} from 'react-router-dom';
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButtom from "react-validation/build/button";
import AuthService from "../services/auth.service";
import isEmail from "validator/lib/isEmail";

const required = (value) => {
    if (!value){
        return(
            <div className="alert alert-danger" role="alert">
                El campo es obligatorio
            </div>
        );
    }
};

const vUsername = (value) => {
    if (value.length < 3|| value.length > 20 ){
        return (
            < div className="alert alert.danger" role="alert">
                El usuario debe tener entre 3 y 20 caracteres
            </div>
        );
    }
};

const validEmail = (value) => {
    if(!isEmail(value)){
        return(
            <div className="alert alert-danger" role="alert">
                No es un email valido
            </div>
        )
    }
}

const vPassword = (value) => {
    if (value.length < 6 || value.length > 40) {
        return (
            <div className="alert alert-danger" role="alert">
                La contraseña debe tener entre 6 y 40 caracteres
            </div>
        );
    }
};

const Register = () => {
    const form = useRef();
    const checkBtn = useRef();

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");
    const [successful, setSuccessful] = useState(false);
    const [message, setMessage] = useState("");

    const onChangeUsername = (e) => {
        const username  = e.target.value;
        setUsername = username;
    }

    const onChangePassword = (e) => {
        const password = e.target.value;
        setPassword = password;
    }

    const onChangeEmail = (e) => {
        const email = e.target.value;
        setEmail = email;
    }

    const handleRegister = (e) => {
        e.prevenDefault();

         setMessage ("");
         setSuccessful(false);

         form.current.validateAll();

         if (checkBtn.current.context._error.length === 0){
            AuthService.register(username, email, password).then(
                (response) => {
                    setMessage(response.data.message);
                    setSuccessful(true);
                },
                (error) => {
                    const resMessage = 
                        (error.response && error.response.data && error.response.data.message) ||
                        error.message || error.toString ();

                        setMessage(resMessage);
                        setSuccessful(false);
                }
            );
         }
    };

    return (
        <div className="col-md-12">
            <div className="card card-container">
                <img src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" 
                alt="profile-img"
                className="profile-img-class"
                />

                <Form onSubmit={handleRegister} ref={form}>
                    {!successful && (
                        <div>
                            <div className="form-group">
                                <label htmlFor="username">Username</label>
                                <Input type="text" className="form-control" name="username" value={"username"} onChange={onChangeUsername} validations={[required, vUsername]} />
                            </div>
                            <div className="form-group">
                                <label htmlFor="email">Email</label>
                                <Input type="text" className="form-control" name="email" value={"email"} onChange={onChangeEmail} validations={[required, validEmail]} />
                            </div>
                            <div className="password">
                                <label htmlFor="password">Password</label>
                                <Input type="password" className="form-control" name="password" value={"password"} onChange={onChangePassword} validations={[required, vPassword]} />
                            </div>
                            <div className="form-group">
                                <button className="btn btn-primary-btn-block">Sign Up</button>
                            </div>
                        </div>
                    )}

                    {message && (
                        <div className="form-group">
                            <div className = {successful ? "alert alert-success" : "alert alert-danger"} role="alert">
                                {message}
                            </div>
                        </div>
                    )};
                    <CheckButtom />
                </Form>
            </div>
        </div>
    );
};

export default Register;