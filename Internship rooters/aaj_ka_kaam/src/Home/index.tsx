import React from 'react';
import style from "./Home.module.css";
function Home() {
  return (
<div className={style.bg}>
<div className={style.Tp1}></div>
<div className={style.Tp2}></div>
<div className={style.Tp3}></div>
<div className={style.Rectangle}></div>
<div className={style.Tp4}></div>
<div className={style['Tp1-Copy']}>Mumbai</div>
<div className={style["mid-section"]}>
<div className={style['headshot']}>Trending
Destinations
<div className={style['tagline']}>A curated list of the top trending destinations to help plan
your travel. </div>
</div>
</div>
</div>
  );
}
export default Home;