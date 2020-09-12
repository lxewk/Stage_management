import React from 'react';
import {
    BrowserRouter as Router,
    Switch,
    Route,
} from 'react-router-dom';
import Navigation from './components/Navigation';
import "bootstrap/dist/css/bootstrap.min.css";
import './App.css';


function App() {
    return (
        <Router>
            <Navigation />
                <Switch>
                    <Route path="/crew">
                        <Crew />
                    </Route>
                </Switch>
        </Router>
    )
}

export default App;