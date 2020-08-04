import React from 'react';
import style from "./Filters.module.css";


function Filters() {
  return (
    <div className={style.wrapper}>
      <div className={style.columnprop}>
        <div className={style.rowprop}>
          <div className={style.filters}>FILTERS</div>
          <input type="reset" value="Reset" />
        </div>
        <div className={style.Bustype} >Bus-Type</div>
        <div className={style.rowprop}>
          <button className={style.btn1}> Seater</button>
          <button className={style.btn1}> Sleeper</button>
        </div>
        <div className={style.rowprop}>
          <button className={style.btn1}> A/C</button>
          <button className={style.btn1}> Non A/C</button>
        </div>
        <div className={style.Departuretime} >Departure Time</div>
        <div className={style.rowprop}>
          <button className={style.btn2}> Befor 6:00A.M</button>
          <button className={style.btn2}> 6:00A.M - 12:00P.M</button>
        </div>
        <div className={style.rowprop}>
          <button className={style.btn2}> 12:00P.M - 6:00 P.M</button>
          <button className={style.btn2}> After 6:00 P.M</button>
        </div>

        <div className={style.Departuretime} id="mybutton3">Arrival Time</div>
        <div className={style.rowprop}>
          <button className={style.btn2}> Befor 6:00A.M</button>
          <button className={style.btn2}> 6:00A.M - 12:00P.M</button>
        </div>
        <div className={style.rowprop}>
          <button className={style.btn2}> 12:00P.M - 6:00 P.M</button>
          <button className={style.btn2}> After 6:00 P.M</button>
        </div>
        <div className={style.Departuretime}>Boarding point</div>
        <div className={style.dropdown}>
          <button className={style.dropbtn}>Bengaluru[All-location]</button>
          <div className={style.dropdowncontent}>
            <a href="#">Link 1</a>
            <a href="#">Link 2</a>
            <a href="#">Link 3</a>
          </div>
        </div>

        <div className={style.Departuretime}>Drop point</div>
        <div className={style.dropdown}>
          <button className={style.dropbtn}>Chennai[All-location]</button>
          <div className={style.dropdowncontent}>
            <a href="#">Link 1</a>
            <a href="#">Link 2</a>
            <a href="#">Link 3</a>
          </div>
        </div>

        <div className={style.Departuretime}>Exclusive Features</div>
        <label className={style.container}>Reschedule
          <input type="checkbox" />
          <span className={style.checkmark}></span>
        </label>
        <label className={style.container}>Free Cancellation
          <input type="checkbox" />
          <span className={style.checkmark}></span>
        </label>
        <label className={style.container}>Wifi
          <input type="checkbox" />
          <span className={style.checkmark}></span>
        </label>



      </div>


    </div >

  );
}

export default Filters;
