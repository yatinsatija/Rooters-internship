import React from 'react';
import style from "./Filters.module.css";
import TypeContainer1 from './containers/bus-type';
import TypeContainer2 from './containers/departure-time';
import TypeContainer3 from './containers/arrival-time';


function Filters() {
  return (
    <div className={style.wrapper}>
      <div className={style.columnprop}>
        <div className={style.rowprop}>
          <div className={style.filters}>FILTERS</div>
          <input type="reset" value="Reset" />
        </div>
        <TypeContainer1 />
        <TypeContainer2 />
        <TypeContainer3 />
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
