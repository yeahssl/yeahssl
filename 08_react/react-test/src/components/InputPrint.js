import React, { useState } from 'react';



const InputPrint = () => {

    const [input , setInputText] = useState('');

    const [addInput, setInput] = useState('위 덱스트필드에 값을 입력하신 후 보내기 버튼을 누르면 이곳에 출력됩니다.');


    const addText = () => {
        const add = {text : input, completed : false}

        setInput(input);
        setInputText('');
    }

    return(

        <>
            <input type='text' onChange={e => setInputText(e.target.value)} />
            <button onClick={addText}>보내기</button>

            <div className='print'><h2>{addInput}</h2></div>
        </>

);

}
export default InputPrint;