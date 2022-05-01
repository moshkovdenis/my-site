import useFetch from "../useFetch";
import {Link} from "react-router-dom";


const AllUsers = () => {
    const [data] = useFetch("http://localhost:8888/api/v1/user/get-all-users");
    return (
        <div>
            <h1 className={'h1 all-users'}>All Users</h1>
            <table className="table table-hover">
                <thead className={"table-dark"}>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Age</th>
                </tr>
                </thead>
                <tbody>
                {data && data.map((item) => {
                    return (
                        <tr className={'table-success'}>
                            <td>{item.name}</td>
                            <td>{item.email}</td>
                            <td>{item.age}</td>
                        </tr>
                    );
                })}
                </tbody>
            </table>
            <Link to="/" className={'btn btn-light'}>Back to Home</Link>
        </div>
    );
};

export default AllUsers;
