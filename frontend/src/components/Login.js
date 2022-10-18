import React, {useState, useRef} from "react";
import {useNavigate} from "react-router-dom";
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButtom from "react-validation/build/button";
import AuthService from "../services/auth.service";


const required = value =>{
if (!value){
    return (
        <div className="alert alert-danger" role="alert">
            El campo es obligatorio
        </div>
    )
}
};

const Login = () =>{
    let navigate = useNavigate();

    const form = useRef();
    const checkBtn = useRef();

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [loading, setLoading] = useState(false);
    const [message, setMessage] = useState("");

    const onChangeUsername = (e) => {
        const username = e.target.value;
        setUsername(username);
    };

    const onchangePassword = (e) => {
        const password = e.target.value;
        setPassword(password);
    };

    const handleLogin = (e) => {
        e.preventDefault();

        setMessage("");
        setLoading(true);

        form.current.validateAll();

        if (checkBtn.current.context._errors.length === 0){
            AuthService.login(username, password).then( () => {
                // navigate("/registerNewUser"); // 
                 navigate("/profile"); // navegamos al "perfil" cuando nos logeemos

                window.location.reload();
            },
            (error) => {
                const resMessage = (error.response && error.response.data && error.response.data.message) || error.message || error.toString();
                setLoading(false);
                setMessage(resMessage);
                        }
            );
        }else{
            setLoading(false);
        }
    };

    return(
        <div className="col-md-12">
            <div className="card card-container">
                <img src="//ssl.gstatic.com/account/ui/avatar_2x.png" 
                     alt="profile-img"
                     className="profile-imf-card"
                    />
                <Form onSubmit={handleLogin} ref={form}>
                    <div className="form-group">
                        <label htmlFor="username">Username</label>
                        <Input type="text" className="form-control" name="username" value={username} onChange={onChangeUsername} validations={[required]} />
                    </div>
                    <div className="form-group">
                        <label type="password" className="form-control" name="password" value={password} onChange={onchangePassword} validations={required} />
                    </div>
                    <div className="form-group">
                        <button className="btn btn-primary btn-block" disabled = {loading}>
                            {loading && (
                                <span className="spinner-border spinner-border-sm"></span>
                            )}
                            <span>Login</span>
                        </button>
                    </div>
                    {message && (
                        <div className="form-group">
                            <div className="alert allert-danger" role="alert">
                                {message}
                            </div>                        
                        </div>
                    )}
                    <CheckButtom style={{display:"none"}} ref={checkBtn} />
                </Form>

            </div>

        </div>
    )
}
export default Login;
/*
const email = value => {
    if (!isEmail(value)) {
        return (
            <div className="aller allert-danger" role="alert">
                No es un email valido
            </div>
        )
    }
};

render (){
    return (

        <Form onSubmit={handleLogin}
        ref={form}
        >
            <Input type="text" className="form-control"   validations={[required, email]} />
            <CheckButtom style={{ display: "none"}} ref={checkBtn} />
        </Form>
    )
}*/
