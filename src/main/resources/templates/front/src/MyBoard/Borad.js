
import React, { useState, useEffect } from 'react';
import './css/styles.css';
const MyBoard = () => {
    const [data, setData] = useState([]);

    useEffect(()=>{
        fetch("/first",{
            method: "GET",
            headers:{
                "Content-Type": "application/json"
            }
        })
            .then((res)=> { return res.json()})
            .then(data=>{
                console.log(data.data)
                setData(data.data);
            });
    }, [])

    return (
        <div>
            <ul>
                <table className="table table-hover">
                    <thead>
                    <tr>
                        <th scope="col">title</th>
                        <th scope="col">content</th>
                        <th scope="col">genre</th>
                        <th scope="col">create date</th>
                    </tr>
                    </thead>
                    <tbody>
                    {data.map(item => (
                        <tr key={item.docNum}>
                            <td className="docTitle">{item.docTitle}</td>
                            <td className="docContent">{item.docContent}</td>
                            <td className="docGenre">{item.docGenre}</td>
                            <td className="docDate">{item.docDate}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>

            </ul>
        </div>
    );
};

export default MyBoard;

