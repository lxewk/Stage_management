import React, { Component } from "react";

import UserService from "../services/user.service";

export default class Dashboard extends Component {
  constructor(props) {
    super(props);

    this.state = {
      content: "MAIN"
    };
  }

  componentDidMount() {
    UserService.getDashboardContent().then(
      response => {
        this.setState({
          content: response.data
        });
      },
      error => {
        this.setState({
          content:
            (error.response && error.response.data) ||
            error.message ||
            error.toString()
        });
      }
    );
  }

  render() {
    return (
      <div className="container">
        <header className="jumbotron">
          <h3>{this.state.content}</h3>
        </header>
      </div>
    );
  }
}