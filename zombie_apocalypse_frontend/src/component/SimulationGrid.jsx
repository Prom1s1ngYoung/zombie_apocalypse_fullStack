import React from "react";
import { Button, Form, Input, InputNumber } from "antd";
import Results from "../pages/Results";

const layout = {
  labelCol: {
    span: 0,
  },
  wrapperCol: {
    span: 16,
  },
};
/* eslint-disable no-template-curly-in-string */

const validateMessages = {
  required: "${label} is required!",
  number: {
    range: "${label} must be between ${min} and ${max}",
  },
};
export default function SimulatioinGrid() {
  const [size, setSize] = React.useState(0);
  const [creatures, setCreatures] = React.useState([]);
  const [zombies, setZombies] = React.useState([]);

  const onFinish = (values) => {
    const creatures = [];
    const data = {};
    const creaturesList = values.user.creature.split(";");
    for (const cor of creaturesList) {
      const creature = {
        x: parseInt(cor.charAt(0)),
        y: parseInt(cor.charAt(2)),
      };
      creatures.push(creature);
    }
    data["dimensions"] = values.user.size;
    setSize(data["dimensions"]);
    data["zombie"] = {
      x: parseInt(values.user.zombie.split(",")[0]),
      y: parseInt(values.user.zombie.split(",")[1]),
    };
    data["creatures"] = creatures;
    data["commands"] = values.user.command;

    fetch(`http://localhost:8080/zombie/infection`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
        "Access-Control-Allow-Origin": "*",
      },
      body: JSON.stringify(data),
    })
      .then((res) => res.json())
      .then((data) => {
        setCreatures(data.data.creatures);
        setZombies(data.data.zombies);
      });
  };
  React.useEffect(() => {}, [size, creatures, zombies]);
  return (
    <Form
      {...layout}
      name="dynamic_form_nest_item"
      onFinish={onFinish}
      validateMessages={validateMessages}
    >
      <Form.Item
        name={["user", "size"]}
        label="Size"
        rules={[
          {
            type: "number",
            min: 2,
            max: 99,
            required: true,
          },
        ]}
      >
        <InputNumber />
      </Form.Item>
      <Form.Item
        name={["user", "zombie"]}
        label="Zombie"
        rules={[
          {
            required: true,
          },
        ]}
      >
        <Input placeholder="1,2" />
      </Form.Item>
      <Form.Item
        name={["user", "creature"]}
        label="Creatureslist"
        rules={[
          {
            required: true,
          },
        ]}
      >
        <Input placeholder="1,2;2,3" />
      </Form.Item>
      <Form.Item
        name={["user", "command"]}
        label="Movement"
        rules={[
          {
            required: true,
          },
        ]}
      >
        <Input placeholder="RURD" />
      </Form.Item>

      <Form.Item wrapperCol={{ ...layout.wrapperCol, offset: 8 }}>
        <Button type="primary" htmlType="submit">
          Submit
        </Button>
      </Form.Item>
      <Results size={size} zombies={zombies} creatures={creatures} />
    </Form>
  );
}
