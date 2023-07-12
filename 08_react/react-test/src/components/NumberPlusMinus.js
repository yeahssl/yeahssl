import React, {useState} from 'react';

function NumberPlusMinus() {


    const [count, setCount] = useState(0);

    const plusClick = () => {
        setCount( () => count +1 );
    };

    const minusClick = () => {
        setCount( () => count -1 );
    }

    return (
        <>
        <button onClick={minusClick} className='minus'>-</button>
        
            <span>{count}</span>
        
        <button onClick={plusClick} className='plus'>+</button>
        
        </>

    );

}

export default NumberPlusMinus;