const express = require('express')
const app = express()
const port = 3000

app.get('/', (req, res) => {
  res.send({"OK": "API is working!"})
})

app.post('/api/makeOrder/', (req, res) => {
  try {
    const { order } = req.body;
    if (!order) {
      throw new Error('Order is required');
    }
    
    res.status(201).send({ message: 'Order created successfully', order });
  } catch (error) {
    res.status(400).send({ error: error.message });
  }
});



app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
})