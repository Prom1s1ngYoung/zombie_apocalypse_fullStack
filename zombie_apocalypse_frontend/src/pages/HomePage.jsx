import React from "react";
import styled from "styled-components";
import SimulationGrid from "../component/SimulationGrid";
const MainContainer = styled.div`
  background-color: bisque;
  height: 100vh;
  margin: 0 auto;
  width: 80%;
  display: flex;
  justify-content: center;
`;

export default function HomePage() {
  return (
    <MainContainer>
      <SimulationGrid />
    </MainContainer>
  );
}
