import { Outlet, Link } from "react-router-dom";

const Layout = () => {
    return (
        <>
            <nav>
                <ul>
                        <Link className={'home-link'} to="/">Home</Link>
                    <br/>
                    <li>
                        <Link to="/all-users">All Users</Link>
                    </li>
                </ul>
            </nav>

            <Outlet />
        </>
    )
};

export default Layout;