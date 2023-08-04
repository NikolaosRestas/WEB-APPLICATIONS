import './App.css';
import {Component} from "react";
import Navbar from "./navbar/Navbar";
import GymsPage from "./gyms/gyms";
import { Switch, Route } from 'react-router-dom';
import CustomersPage from "./customers/customers";

class App extends Component {

    render() {
        return (
            <div>
                <Navbar/>
                <Switch>
                    <Route path="/home" component={CustomersPage} />
                    <Route path="/customers" component={CustomersPage} />
                    <Route path="/gyms" component={GymsPage} />
                </Switch>

            </div>
        );
    }
}

export default App;
