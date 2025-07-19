import React, { Component } from 'react';

class UsersList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            users: []
        };
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        fetch("/allUsers")
            .then(response => response.json())
            .then(data => this.setState({ users: data }))
    }
    async remove(id) {
        await fetch(`/delete/${id}`, {
            methiod: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedUsers = [...this.state.users].filter(i => i.id !== id);
            this.setState({ users: updatedUsers });
        })
    }

    render(){
        const {users, isLoading} = this.state;
        if (isLoading) {
            return <p>Loading...</p>;
        }
        const userList = users.map(user => {
            return <div key={user.id}>
                {user.username} - {user.full_name} - {user.email} - {user.role}
                <button onClick={() => this.remove(user.id)}>Delete</button>
            </div>
        });
    }

}
export default UsersList;