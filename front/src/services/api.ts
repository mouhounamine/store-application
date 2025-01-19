async function fetchdetails() {
  const response = await fetch("http://localhost:8081/home/great");
  if (response.ok) {
    const responseBody = await response.json();
    // console.log(`data ${data}`);
    // setData(responseBody);
    console.log(`data ${responseBody}`);
    return responseBody;
  }
}
