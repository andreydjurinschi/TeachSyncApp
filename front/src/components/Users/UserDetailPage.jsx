import {
  useEffect,
  useState,
} from 'react';

import {
  Link,
  useParams,
} from 'react-router-dom';

import Button from '../buttons/Button';

export default function UserDetailPage() {
    const { id } = useParams();
    const [user, setUser] = useState(null);

    useEffect(() => {
        fetch(`http://localhost:8080/users/${id}`)
            .then(res => res.json())
            .then(data => setUser(data))
    }, [id])

    if (!user) {
        return <div>Loading...</div>;
    }

      return (
    <div>
      <h2>User Details</h2>
      <Link to="/users" className={location.pathname === "/" ? "active" : ""}>Назад</Link>
      <p><strong>Username:</strong> {user.username}</p>
      <p><strong>Full Name:</strong> {user.full_name}</p>
      <p><strong>Email:</strong> {user.email}</p>
      <p><strong>Role:</strong> {user.role}</p>
    </div>
  );
}