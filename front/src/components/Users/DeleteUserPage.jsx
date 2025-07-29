import {
    useEffect,
    useState,
} from 'react';

import {
    Link,
    useParams,
    useNavigate
} from 'react-router-dom';

import Button from '../buttons/Button';

export default function DeleteUserPage() {
    const navigate = useNavigate();
    const { id } = useParams();
    const [userToDelete, setUserToDelete] = useState(null);

    useEffect(() => {
        fetch(`http://localhost:8080/users/${id}`)
            .then(res => res.json())
            .then(data => setUserToDelete(data))
    }, [id]);

    const handleDelete = () => {
        fetch(`http://localhost:8080/users/delete/${id}`, {
            method: 'DELETE'
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Failed to delete user");
                }
                return
            })
            .then(() => {
                alert("User deleted successfully");
                navigate('/users');
            })
            .catch((error) => {
                alert(error.message);
            });
    };

    if (!userToDelete) {
        return <div>Loading...</div>;
    }


    return (
        <div>
            <h2>User Details</h2>
            <Link to="/users" className={location.pathname === "/" ? "active" : ""}>Назад</Link>
            <p><strong>Username:</strong> {userToDelete.username}</p>
            <p><strong>Full Name:</strong> {userToDelete.full_name}</p>
            <p><strong>Email:</strong> {userToDelete.email}</p>
            <p><strong>Role:</strong> {userToDelete.role}</p>
            <Button onClick={handleDelete}>Delete User</Button>
        </div>
    );
}