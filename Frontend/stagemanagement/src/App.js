import React, { Component } from "react";
import { Switch, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

import AuthService from "./services/auth.service";

import Login from "./components/login";
import Dashboard from "./components/dashboard";
import Account from "./components/account";
import BoardCrew from "./components/crew";
import BoardStagemanager from "./components/stagemanager";
import BoardDeputy from "./components/deputy";

class App extends Component {
  constructor(props) {
    super(props);
    this.logOut = this.logOut.bind(this);

    this.state = {
      showStagemanagerBoard: false,
      showDeputyBoard: false,
      currentUser: undefined,
    };
  }

  componentDidMount() {
    const user = AuthService.getCurrentUser();

    if (user) {
      this.setState({
        currentUser: user,
        showStagemanagerBoard: user.roles.includes("STAGEMANAGER"),
        showDeputyBoard: user.roles.includes("DEPUTY"),
      });
    }
  }

  logOut() {
    AuthService.logout();
  }

  render() {
    const { currentUser, showStagemanagerBoard, showDeputyBoard } = this.state;

    return (
      <div>
        <nav className="navbar navbar-expand navbar-dark bg-dark">
          <Link to={"/"} className="navbar-brand">
            Stage management
          </Link>
          <div className="navbar-nav mr-auto">
            <li className="nav-item">
              <Link to={"/api/dashboard/all"} className="nav-link">
                Dashboard
              </Link>
            </li>

            {showStagemanagerBoard && (
              <li className="nav-item">
                <Link to={"/api/test/stagemanager"} className="nav-link">
                  Stagemanager Board
                </Link>
              </li>
            )}

            {showDeputyBoard && (
              <li className="nav-item">
                <Link to={"/api/test/deputy"} className="nav-link">
                  Deputy Board
                </Link>
              </li>
            )}

            {currentUser && (
              <li className="nav-item">
                <Link to={"/api/dashboard/all"} className="nav-link">
                  You
                </Link>
              </li>
            )}
          </div>

          {currentUser ? (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <Link to={"/account"} className="nav-link">
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
            </div>
          )}
        </nav>

        <div className="container mt-3">
          <Switch>
            <Route exact path={["/", "/dashboard"]} component={Dashboard} />
            <Route exact path="/login" component={Login} />
            <Route exact path="/account" component={Account} />
            <Route path="/user" component={BoardCrew} />
            <Route path="/mod" component={BoardStagemanager} />
            <Route path="/admin" component={BoardDeputy} />
          </Switch>
        </div>
      </div>
    );
  }
}

export default App;