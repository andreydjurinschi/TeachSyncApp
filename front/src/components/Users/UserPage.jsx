import {
  useEffect,
  useState,
} from 'react';

import {
  Link,
  useLocation,
} from 'react-router-dom';

export default function UserPage() {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const location = useLocation();

  useEffect(() => {
    fetch("http://localhost:8080/users/allUsers")
      .then((resp) => {
        if (!resp.ok) {
          throw new Error("Network response was not ok");
        }
        return resp.json();
      })
      .then((data) => {
        setUsers(data);
        setLoading(false);
      })
      .catch((error) => {
        setError(error);
        setLoading(false);
      });
  }, []);

  if (loading) {
    return (
    <>
    <div>
      
      <Link to="/users-create" className={location.pathname === "/users-create" ? "active" : ""}>Create User</Link>
      <br />
      Loading...


    </div>
    </>
    )
  }
  if (error) {
    return(
    <>
    <div>
      <Link to="/users-create" className={location.pathname === "/users-create" ? "active" : ""}>Create User</Link>
      <br />
      Error... {error.message}
    </div>
    </>
    )
  }

  return (
    <div>
      {/* <CreatePage /> */}
      <Link to="/users-create" className={location.pathname === "/users-create" ? "active" : ""}>Create User</Link>
      <Link to="/users-create" className={location.pathname === "/users-create" ? "active" : ""}>Create User</Link>

      
      <h3>User Page</h3>
          <table>
            <thead>
              <tr>
                <th>Username</th>
                <th>Full Name</th>
                <th>Email</th>
                <th>Role</th>
              </tr>
            </thead>
            <tbody>
              {users.map((user) => (
                <tr key={user.id}>
                  <td>{user.username}</td>
                  <td>{user.full_name}</td>
                  <td>{user.email}</td>
                  <td>{user.role}</td>
                </tr>
              ))}
            </tbody>
          </table>

    </div>
  );
}
