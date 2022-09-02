import React from "react";
import styled from "styled-components";
const Container = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
`;
const generateEmptyGrid = (numRows, numCols) => {
  const rows = [];
  for (let i = 0; i < numRows; i++) {
    rows.push(Array.from(Array(numCols), () => 0));
  }
  return rows;
};
export default function Results(props) {
  const numRows = props.size;
  const numCols = props.size;
  const creatures = props.creatures;
  const zombies = props.zombies;

  const grid = generateEmptyGrid(numRows, numCols);
  creatures.forEach((creature) => {
    grid[creature["y"]][creature["x"]] = 1;
  });
  zombies.forEach((zombie) => {
    grid[zombie["y"]][zombie["x"]] = -1;
  });
  return (
    <Container>
      <div
        style={{
          display: "grid",
          gridTemplateColumns: `repeat(${numCols},20px)`,
        }}
      >
        {grid.map((rows, i) =>
          rows.map((col, k) => (
            <div
              key={`${i}-${k}`}
              style={{
                width: 20,
                height: 20,
                backgroundColor:
                  grid[i][k] === 0
                    ? undefined
                    : grid[i][k] === 1
                    ? "pink"
                    : "red",
                border: "solid 1px black",
              }}
            />
          ))
        )}
      </div>
    </Container>
  );
}
