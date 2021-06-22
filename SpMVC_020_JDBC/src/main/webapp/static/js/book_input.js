document.addEventListener("DOMContentLoaded", () => {
  let modal = document.querySelector("div#modal");
  modal.querySelector("span").addEventListener("click", (e) => {
    // 임의로 생성된 div_search Box는
    // modal과 별개로 생성을 하였으므로
    // div_search box를 remove하고 modal을 감춘다
    document.querySelector("div#div_search").remove();
    modal.style.display = "none";
  });
  document.querySelector("form#book_input").addEventListener("keydown", (e) => {
    let key = e.key;
    let tagName = e.target.tagName;
    let id = e.target.id;
    if (key === "Enter" && tagName === "INPUT") {
      let text = e.target.value;

      if (id === "bk_ccode") {
        fetch(`${rootPath}/comp/search`)
          .then((res) => {
            return res.text();
          })
          .then((result) => {
            // 새로운 element(tag)
            let div = document.createElement("div");
            // 본문 내용 추가
            div.innerHTML = result;
            // id 추가
            div.setAttribute("id", "div_search");
            document.querySelector("body").appendChild(div);
          });

        modal.style.display = "block";
      } else if (id === "bk_acode") {
        modal.style.display = "block";
      }
    }
  });
});
