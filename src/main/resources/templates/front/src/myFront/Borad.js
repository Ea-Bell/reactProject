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
    }, [])
    const onclick=()=>{
        console.log("onclick", sendData)

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

        console.log(sendData)
    }

    const inputText=(e)=>{
        setSendData({
            ...sendData,                    //spread 문법 기존에 있는 값들을 가져온다.
            [e.target.name]:e.target.value  // 해당 배열의 값은 변경해준다.
        });
    }
    return(
        <>
            <input name="text" onChange={inputText}/>
            <button type={"button"} className={"btn btn-primary"} onClick={onclick}>Default</button>
        </>
    )
}
