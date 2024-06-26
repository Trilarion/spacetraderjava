package org.spacetrader.model.enums;


import org.spacetrader.util.IdentifiableEnum;

public enum AlertType implements IdentifiableEnum {
    Alert,
    AntidoteOnBoard,
    AntidoteDestroyed,
    AntidoteTaken,
    AppStart,
    ArrivalBuyNewspaper,
    ArrivalIFFuel,
    ArrivalIFFuelRepairs,
    ArrivalIFNewspaper,
    ArrivalIFRepairs,
    ArtifactLost,
    ArtifactRelinquished,
    CargoIF,
    CargoNoEmptyBays,
    CargoNoneAvailable,
    CargoNoneToSell,
    CargoNotInterested,
    CargoNotSold,
    ChartJump,
    ChartJumpCurrent,
    ChartJumpNoSystemSelected,
    ChartTrackSystem,
    ChartWormholeUnreachable,
    Cheater,
    CrewFireMercenary,
    CrewNoQuarters,
    DebtNoBuy,
    DebtNone,
    DebtReminder,
    DebtTooLargeGrounded,
    DebtTooLargeLoan,
    DebtTooLargeTrade,
    DebtWarning,
    Egg,
    EncounterAliensSurrender,
    EncounterArrested,
    EncounterAttackCaptain,
    EncounterAttackNoDisruptors,
    EncounterAttackNoLasers,
    EncounterAttackNoWeapons,
    EncounterAttackPolice,
    EncounterAttackTrader,
    EncounterBothDestroyed,
    EncounterDisabledOpponent,
    EncounterDrinkContents,
    EncounterDumpAll,
    EncounterDumpWarning,
    EncounterEscaped,
    EncounterEscapedHit,
    EncounterEscapePodActivated,
    EncounterLooting,
    EncounterMarieCeleste,
    EncounterMarieCelesteNoBribe,
    EncounterOpponentEscaped,
    EncounterPiratesBounty,
    EncounterPiratesExamineReactor,
    EncounterPiratesFindNoCargo,
    EncounterPiratesSurrenderPrincess,
    EncounterPiratesTakeSculpture,
    EncounterPoliceBribe,
    EncounterPoliceBribeCant,
    EncounterPoliceBribeLowCash,
    EncounterPoliceFine,
    EncounterPoliceNothingFound,
    EncounterPoliceNothingIllegal,
    EncounterPoliceSubmit,
    EncounterPoliceSurrender,
    EncounterPostMarie,
    EncounterPostMarieFlee,
    EncounterScoop,
    EncounterScoopNoRoom,
    EncounterScoopNoScoop,
    EncounterSurrenderRefused,
    EncounterTonicConsumedGood,
    EncounterTonicConsumedStrange,
    EncounterTradeCompleted,
    EncounterYouLose,
    EncounterYouWin,
    EquipmentAlreadyOwn,
    EquipmentBuy,
    EquipmentEscapePod,
    EquipmentExtraBaysInUse,
    EquipmentFuelCompactor,
    EquipmentHiddenCompartments,
    EquipmentIF,
    EquipmentLightningShield,
    EquipmentMorgansLaser,
    EquipmentNotEnoughSlots,
    EquipmentQuantumDisruptor,
    EquipmentSell,
    FileErrorOpen,
    FileErrorSave,
    FleaBuilt,
    GameAbandonConfirm,
    GameClearHighScores,
    GameEndBoughtMoon,
    GameEndBoughtMoonGirl,
    GameEndHighScoreAchieved,
    GameEndHighScoreCheat,
    GameEndHighScoreMissed,
    GameEndKilled,
    GameEndRetired,
    GameEndScore,
    GameRetire,
    InsuranceNoEscapePod,
    InsurancePayoff,
    InsuranceStop,
    JailConvicted,
    JailFleaReceived,
    JailHiddenCargoBaysRemoved,
    JailIllegalGoodsImpounded,
    JailInsuranceLost,
    JailMercenariesLeave,
    JailShipSold,
    JarekTakenHome,
    LeavingIFInsurance,
    LeavingIFMercenaries,
    LeavingIFWormholeTax,
    MeetCaptainAhab,
    MeetCaptainConrad,
    MeetCaptainHuie,
    NewGameConfirm,
    NewGameMoreSkillPoints,
    PreciousHidden,
    PrincessTakenHome,
    ReactorConfiscated,
    ReactorDestroyed,
    ReactorOnBoard,
    ReactorMeltdown,
    ReactorWarningFuel,
    ReactorWarningFuelGone,
    ReactorWarningTemp,
    RegistryError,
    SculptureConfiscated,
    SculptureSaved,
    ShipBuyConfirm,
    ShipBuyCrewQuarters,
    ShipBuyIF,
    ShipBuyIFTransfer,
    ShipBuyNoSlots,
    ShipBuyNotAvailable,
    ShipBuyNoTransfer,
    ShipBuyPassengerQuarters,
    ShipBuyReactor,
    ShipBuyTransfer,
    ShipDesignIF,
    ShipDesignThanks,
    ShipHullUpgraded,
    SpecialCleanRecord,
    SpecialExperimentPerformed,
    SpecialIF,
    SpecialMoonBought,
    SpecialNoQuarters,
    SpecialNotEnoughBays,
    SpecialPassengerConcernedJarek,
    SpecialPassengerConcernedPrincess,
    SpecialPassengerConcernedWild,
    SpecialPassengerImpatientJarek,
    SpecialPassengerImpatientPrincess,
    SpecialPassengerImpatientWild,
    SpecialPassengerOnBoard,
    SpecialSealedCanisters,
    SpecialSkillIncrease,
    SpecialSpacetimeFabricRip,
    SpecialTrainingCompleted,
    TravelArrival,
    TravelUneventfulTrip,
    TribblesAllDied,
    TribblesAteFood,
    TribblesGone,
    TribblesHalfDied,
    TribblesKilled,
    TribblesMostDied,
    TribblesOwn,
    TribblesRemoved,
    TribblesInspector,
    TribblesSqueek,
    TribblesTradeIn,
    WildArrested,
    WildChatsPirates,
    WildGoesPirates,
    WildLeavesShip,
    WildSculpture,
    WildWontBoardLaser,
    WildWontBoardReactor,
    WildWontStayAboardLaser,
    WildWontStayAboardReactor;

    @Override
    public int getId() {
        return ordinal();
    }
}
