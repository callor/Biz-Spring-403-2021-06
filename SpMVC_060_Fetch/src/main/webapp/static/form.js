let button = document.querySelector("button#form_1");
if (button) {
  button.addEventListener("click", (e) => {
    let form1 = document.querySelector("form#user_form");
    if (form1) {
      // form1.submit();

      // JS 를 사용하여 서버로 form에 담긴 데이터 전달하기
      // 1. form에 담긴 데이터를 FormData 객체로 변환하기
      const formData = new FormData(form1);
      const plainFormData = Object.fromEntries(formData.entries());
      const jsonFormData = JSON.stringify(plainFormData);

      const jsonOption = {
        method: "POST",
        headers: {
          "content-Type": "application/json;char=UTF8",
        },
        body: jsonFormData,
      };
      fetch(`${rootPath}/form`, jsonOption)
        .then((res) => res.json())
        .then((result) => {
          document.writeln(JSON.stringify(result));
        });
    }
  });

  let button_2 = document.querySelector("button#form_2");
  if (button_2) {
    button_2.addEventListener("click", (e) => {
      let form1 = document.querySelector("form#user_form");
      const formData = new FormData(form1);

      fetch(`${rootPath}/form`, {
        method: "POST",
        body: new URLSearchParams({ formData, name: "홍길동" }),
      })
        .then((res) => res.json())
        .then((result) => document.writeln(JSON.stringify(result)));
    });
  }
}
