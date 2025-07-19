import { Component, use } from "react";
import logo from './logo.svg';

class App extends Component{
  state = {
    users: []
  };

  async componentDidMount() {
    const response = await fetch("http://localhost:8080/users/allUsers");
    const body = await response.json();
    this.setState({ users: body });
  }

  render(){
    const { users } = this.state;
    return (
      <div className="App">
        <header className="App-header">
        <div className="App-intro">
          <h1>Users</h1>
          {
            users.map(user => 
              <div key={user.id}>
                {user.username} - {user.full_name} - {user.email} - {user.role}
              </div>
            )
          }
        </div>
        </header>
      </div>
    )
  }
}
export default App;