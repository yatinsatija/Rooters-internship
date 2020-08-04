import React from 'react';
import style from "../Filters.module.css";


function TypeComponent1(
    {
        onTypeChange,
        selectedTypeList
    }: {
        onTypeChange: (label: string) => void,
        selectedTypeList: string[]
    }) {
    return (
        <>
            <div className={style.Bustype} >Bus-Type</div>
            <div className={style.rowprop}>
                <button className={`${style.btn1} ${selectedTypeList.includes('SEATER') ? style['btn1-active'] : ''}`} onClick={() => onTypeChange('SEATER')}>Seater</button>
                <button className={`${style.btn1} ${selectedTypeList.includes('SLEEPER') ? style['btn1-active'] : ''}`} onClick={() => onTypeChange('SLEEPER')}>Sleeper</button>
            </div>
            <div className={style.rowprop}>
                <button className={`${style.btn1} ${selectedTypeList.includes('AC') ? style['btn1-active'] : ''}`} onClick={() => onTypeChange('AC')}>A/C</button>
                <button className={`${style.btn1} ${selectedTypeList.includes('NONAC') ? style['btn1-active'] : ''}`} onClick={() => onTypeChange('NONAC')}>Non A/C</button>
            </div>
        </>

    );
}

export default TypeComponent1;
