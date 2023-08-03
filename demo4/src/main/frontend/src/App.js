import './App.css';

import {Component} from "react";
import {Button, Container, Table} from "@mui/material";

class App extends Component {
    state = {
        clients: []
    };

    async componentDidMount() {
        fetch('http://localhost:8080/customers')
            .then(response => response.json())
            .then(data => {
                this.setState({clients: data});
            });
    }

    render() {
        const {clients} = this.state;
        const clientList = clients.map(client => {
            return <tr key={client.id}>
                <td style={{whiteSpace: 'nowrap'}}>{client.name}</td>
                <td>{client.email}</td>
            </tr>
        });

        return (
            <div>
                <Container fluid>
                    <h3>Clients</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="30%">Name</th>
                            <th width="30%">Email</th>
                        </tr>
                        </thead>
                        <tbody>
                        {clientList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default App;
