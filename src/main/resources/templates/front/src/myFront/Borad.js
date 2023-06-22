import {useEffect, useState} from "react";

export default function Borad (){

    const [sendData, setSendData]=useState({
        text:''
    }) // json형태로 보내야 서버에서 map으로 받을 수 있다.

    const {text}= sendData;

    useEffect(()=>{
        fetch("/first",{
            method: "GET",
            headers:{
                "Content-Type": "application/json"
            }
        })
            .then((res)=> { return res.json()})
            .then(data=>{
                console.log(data);
            })
    }, []);

    const onclick=()=>{
        fetch("/text",{
            method: "POST",
            headers:{
                "Content-Type": "application/json"
            },
            body:JSON.stringify(sendData)
        })
            .then((res)=> { return res.json()})
            .then(data=>{
                console.log(data);
            })
    }
    //spread 문법
    const inputText=(e)=>{
        setSendData({
            ...sendData,
            [e.target.name]:e.target.value //[key]: 변경할 내용
        });
    }
    return(
        <>
            <input name="text" value={sendData.text} onChange={inputText}/>
            <button type={"button"} className={"btn btn-primary"} onClick={onclick}>Default</button>
        </>
    )
}
