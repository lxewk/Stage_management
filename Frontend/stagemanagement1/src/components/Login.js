import React, { useState, useContext } from "react";
import { AuthContext } from "../App";

import { LoginContainer, LoginCard, LoginCardContainer, LoginCardContainerHead, LoginFormContainer } from "../styles/elements";
import { LoginButton } from './button/LoginButton';



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
        <LoginContainer>
            <LoginCard>
                <LoginCardContainer>
                    <LoginFormContainer onSubmit={handleFormSubmit}>
                        <LoginCardContainerHead>Login</LoginCardContainerHead>
                        
                        <label htmlFor="fName">
                        Username
                        <input
                            type="text"
                            value={data.fName}
                            onChange={handleInputChange}
                            name="fName"
                            id="fName"
                            placeholder="pvdHelm"
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
                        
                        <LoginButton disabled={data.isSubmitting}>
                            {data.isSubmitting ? ("Loading...") : ("Login")}                                                                                        
                        </LoginButton>
                    
                    </LoginFormContainer>
                </LoginCardContainer>
            </LoginCard>
        </LoginContainer>
    );
};

export default Login;
