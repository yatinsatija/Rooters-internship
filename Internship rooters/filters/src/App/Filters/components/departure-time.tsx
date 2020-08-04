import React from 'react';
import style from "../Filters.module.css";


function TypeComponent2(
    {
        onTypeChange,
        selectedTypeList
    }: {
        onTypeChange: (label: string) => void,
        selectedTypeList: string[]
    }) {
    return (
        <>
            <div className={style.Departuretime} >Departure-Time</div>
            <div className={style.rowprop}>
                <button className={`${style.btn1} ${selectedTypeList.includes('Befor 6:00A.M') ? style['btn1-active'] : ''}`} onClick={() => onTypeChange('Befor 6:00A.M')}>Befor 6:00A.M</button>
                <button className={`${style.btn1} ${selectedTypeList.includes('6:00A.M - 12:00P.M') ? style['btn1-active'] : ''}`} onClick={() => onTypeChange('6:00A.M - 12:00P.M')}>6:00A.M - 12:00P.M</button>
            </div>
            <div className={style.rowprop}>
                <button className={`${style.btn1} ${selectedTypeList.includes('12:00P.M - 6:00 P.M') ? style['btn1-active'] : ''}`} onClick={() => onTypeChange('12:00P.M - 6:00 P.M')}>12:00P.M - 6:00 P.M</button>
                <button className={`${style.btn1} ${selectedTypeList.includes('After 6:00 P.M') ? style['btn1-active'] : ''}`} onClick={() => onTypeChange('NONAC')}>After 6:00 P.M</button>
            </div>
        </>

    );
}

export default TypeComponent2;
