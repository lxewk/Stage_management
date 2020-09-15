import React, { useState, useContext } from "react";
import logo from "../logo.svg";
import { AuthContext } from "../App";


export const Login = () => {

    const { dispatch } = useContext(AuthContext);

    const initialState = {
        fName: "",
        password: "",
        isSubmitting: false,
        errorMessage: null
    };

    const [data, setData] = useState(initialState);
    const handleInputChange = event => {
        setData({
            ...data,
            [event.target.name]: event.target.value
        });
    };

    const handleFormSubmit = event => {
        event.preventDefault();
        setData({
          ...data,
          isSubmitting: true,
          errorMessage: null
        });
   

        fetch("http://localhost:8080/api/auth/signin", {
            method: "post",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                username: data.fName,
                password: data.password
            })
        })
            .then(res => {
                if (res.ok) {
                    return res.json();
                }
                throw res;
            })

            .then(resJson => {
                dispatch({
                    type: "LOGIN",
                    payload: resJson
                })
            })

            .catch(error => {
                setData({
                    ...data,
                    isSubmitting: false,
                    errorMessage: error.message || error.statusText
                });
            });
    };

    return (
        <div className="login-container">
            <div className="card">
                <div className="container">
                    <form onSubmit={handleFormSubmit}>
                        <h1>Login</h1>
                        
                        <label htmlFor="fName">
                        Username
                        <input
                            type="text"
                            value={data.fName}
                            onChange={handleInputChange}
                            name="fName"
                            id="fName"
                            placeholder="i.e. dVries"
                        />
                        </label>
                        
                        <label htmlFor="password">
                        Password
                        <input
                            type="password"
                            value={data.password}
                            onChange={handleInputChange}
                            name="password"
                            id="password"
                        />
                        </label>

                        {data.errorMessage && (
                            <span className="form-error">{data.errorMessage}</span>
                )}
                        
                        <button disabled={data.isSubmitting}>
                            {data.isSubmitting ? ("Loading...") : ("Login")}                                                                                        
                        </button>
                    
                    </form>
                </div>
            </div>
        </div>
    );
};

export default Login;
