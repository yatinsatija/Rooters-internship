import React from 'react';
import style from "./Header.module.css";


function Header() {
  const onSCrollDownClick : () => void = React.useCallback(() => {
    window.scrollTo({
      top: window.innerHeight,
      left: 0,
      behavior: "smooth"
    });
  }, []);
  return (
    <div className={style.wrapper}>
      <div className={style['header']}>
        <div className={style['side-menu']}></div>
        <div className={style.logo}></div>
        <div className={style.menu}>
          <span className={style.item}>Home</span>
          <span className={style.item}>PNR Search</span>
          <span className={style.item}>Help</span>
          <span className={style.item}>Sign up</span>
        </div>
      </div>
      <div className={style["mid-section"]}>
        <div className={style["heading-1"]}>Discover</div>
        <div className={style["heading-2"]}>The new way to search for the best bus rides in town.</div>
      </div>
      <div className={style.footer}>
        <div className={style["scroll-wrapper"]} onClick={onSCrollDownClick}>
          <div className={style["scroll-text"]}>Scroll down</div>
          <div className={style["scroll-image"]}></div>
        </div>
      </div>
    </div>
  );
}

export default Header;
