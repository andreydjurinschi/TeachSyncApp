import { useState } from 'react';

import {
  Link,
  useLocation,
} from 'react-router-dom';

export default function Header() {
  const [now, setTime] = useState(new Date());
  setInterval(() => {
    setTime(new Date());
  }, 1000);
  const location = useLocation();
  return (
    <div className="header">
      <img src="/logo-app.jpg"></img>
      <div className="header-right">
        {/* <Link to="/" className={location.pathname === "/" ? "active" : ""}>Home</Link> */}
        <Link to="/users" className={location.pathname === "/users" ? "active" : ""}>Users</Link>
        {/* <Link to="/about" className={location.pathname === "/about" ? "active" : ""}>About</Link> */}
        <span>{now.toLocaleTimeString()}</span>
      </div>
    </div>
  )
}