import React, { useContext, useState, useEffect } from 'react';
import { LoginContext } from '../context/LoginProvider';

import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";

import AuthService from "../services/auth.service";


const required = value => {
    if (!value) {
      return (
        <div role="alert">
          This field is required!
        </div>
      );
    }
  };

const Login = (props) => {
    const userLoginDetails = useContext(LoginContext);
    const [error, setError] = useState(null);
    
    const onChangeUsername = (e) => {
        userLoginDetails.setUsername(e.target.value);
    }

    const onChangePassword = (e) => {
        userLoginDetails.setPassword(e.target.value);
    }

    const handleLogin = (e) => {
        e.preventDefault();

        userLoginDetails.setMessage("");
        userLoginDetails.setLoading(true);

        this.form.validateAll();

        {checkBtn.context._errors.length === 0 &&
            AuthService.login(userLoginDetails.currentUser, userLoginDetails.currentPassword)
            try{
                this.props.history.push("/dashboard");
                window.location.reload();
                userLoginDetails.setLoading(false);
            } catch(error) {
                setError(error);
                userLoginDetails.setLoading(false);
                userLoginDetails.setMessage(error);
            }

        }
    }


    return (
        <div className="col-md-12">
            <Form
              onSubmit={handleLogin}
              ref={c => {
                this.form = c;
              }}
            >
              <div className="form-group">
                <label htmlFor="username">Username</label>
                <Input
                  type="text"
                  className="form-control"
                  name="username"
                  value={userLoginDetails.currentUser}
                  onChange={onChangeUsername}
                  validations={[required]}
                />
              </div>
  
              <div className="form-group">
                <label htmlFor="password">Password</label>
                <Input
                  type="password"
                  className="form-control"
                  name="password"
                  value={userLoginDetails.currentPassword}
                  onChange={onChangePassword}
                  validations={[required]}
                />
              </div>
  
              <div className="form-group">
                <button
                  className="btn btn-primary btn-block"
                  disabled={userLoginDetails.currentLoading}
                >
                  {userLoginDetails.currentLoading && 
                    <span className="spinner-border spinner-border-sm"></span>
                  }
                  <span>Login</span>
                </button>
              </div>
  
              {userLoginDetails.currentMessage && 
                <div className="form-group">
                  <div className="alert alert-danger" role="alert">
                    {userLoginDetails.currentMessage}
                  </div>
                </div>
              }
              <CheckButton
                style={{ display: "none" }}
                ref={c => {
                  this.checkBtn = c;
                }}
              />
            </Form>
          
        </div>
    );
};

export default Login;



