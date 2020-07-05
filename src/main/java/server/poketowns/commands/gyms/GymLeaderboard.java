package server.poketowns.commands.gyms;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.text.format.TextStyles;

import server.poketowns.gyms.Gym;
import server.poketowns.gyms.GymManager;

public class GymLeaderboard implements CommandExecutor{
	public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
		if(source instanceof Player){
			//prevent undefined
			Player p = (Player) source;
			Gym gym1 = null;
			Gym gym2 = null;
			Gym gym3 = null;
			Gym gym4 = null;
			Gym gym5 = null;
			Gym gym6 = null;
			Gym gym7 = null;
			Gym gym8 = null;
			Gym gym9 = null;
			Gym gym10 = null;
			p.sendMessage(Text.of(TextStyles.BOLD,TextColors.BLUE,"Top 10 Gyms:"));
			if(GymManager.getInstance().getGyms()==null){
				p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"There Are No Gyms!"));
				return CommandResult.successCount(9);
			}
			for(Gym gym:GymManager.getInstance().getGyms()){
					if(gym.getLosses()==0){
						gym.addFakeLoss();
					}
				if(gym1!=null){
					if(gym1.getLosses()==0||gym.getLosses()==0){
						gym.addFakeLoss();
						gym1.addFakeLoss();
						if(gym1.getWins()<gym.getWins()){
							if(gym2!=null){
								if(gym3!=null){
									if(gym4!=null){
										if(gym5!=null){
											if(gym6!=null){
												if(gym7!=null){
													if(gym8!=null){
														if(gym9!=null){
															if(gym10!=null){
																gym10 = gym9;
																gym9=gym8;
																gym8=gym7;
																gym7=gym6;
																gym6=gym5;
																gym5=gym4;
																gym4=gym3;
																gym3=gym2;
																gym2=gym1;
																gym=gym1;
																continue;
															}else{
																gym10 = gym9;
																gym9=gym8;
																gym8=gym7;
																gym7=gym6;
																gym6=gym5;
																gym5=gym4;
																gym4=gym3;
																gym3=gym2;
																gym2=gym1;
																gym=gym1;
																continue;
															}
														}else{
															gym9=gym8;
															gym8=gym7;
															gym7=gym6;
															gym6=gym5;
															gym5=gym4;
															gym4=gym3;
															gym3=gym2;
															gym2=gym1;
															gym=gym1;
															continue;
															
														}
													}else{
														gym8=gym7;
														gym7=gym6;
														gym6=gym5;
														gym5=gym4;
														gym4=gym3;
														gym3=gym2;
														gym2=gym1;
														gym=gym1;
														continue;
													}
												}else{
													gym7=gym6;
													gym6=gym5;
													gym5=gym4;
													gym4=gym3;
													gym3=gym2;
													gym2=gym1;
													gym=gym1;
													continue;
												}
											}else{
												gym6=gym5;
												gym5=gym4;
												gym4=gym3;
												gym3=gym2;
												gym2=gym1;
												gym=gym1;
												continue;
											}
										}else{
											gym5=gym4;
											gym4=gym3;
											gym3=gym2;
											gym2=gym1;
											gym=gym1;
											continue;
										}
									}else{
										gym4=gym3;
										gym3=gym2;
										gym2=gym1;
										gym=gym1;
										continue;
									}
								}else{
									gym3=gym2;
									gym2=gym1;
									gym=gym1;
									continue;
								}
							}else{
								gym2=gym1;
								gym=gym1;
								continue;
							}
						}
						
					}
					if((gym1.getWins()/gym1.getLosses())<(gym.getWins()/gym.getLosses())){
						
						gym1.removeFakeLoss();
						if(gym2!=null){
							if(gym3!=null){
								if(gym4!=null){
									if(gym5!=null){
										if(gym6!=null){
											if(gym7!=null){
												if(gym8!=null){
													if(gym9!=null){
														if(gym10!=null){
															gym10 = gym9;
															gym9=gym8;
															gym8=gym7;
															gym7=gym6;
															gym6=gym5;
															gym5=gym4;
															gym4=gym3;
															gym3=gym2;
															gym2=gym1;
															gym=gym1;
															continue;
														}else{
															gym10 = gym9;
															gym9=gym8;
															gym8=gym7;
															gym7=gym6;
															gym6=gym5;
															gym5=gym4;
															gym4=gym3;
															gym3=gym2;
															gym2=gym1;
															gym=gym1;
															continue;
														}
													}else{
														gym9=gym8;
														gym8=gym7;
														gym7=gym6;
														gym6=gym5;
														gym5=gym4;
														gym4=gym3;
														gym3=gym2;
														gym2=gym1;
														gym=gym1;
														continue;
													}
												}else{
													gym8=gym7;
													gym7=gym6;
													gym6=gym5;
													gym5=gym4;
													gym4=gym3;
													gym3=gym2;
													gym2=gym1;
													gym=gym1;
													continue;
												}
											}else{
												gym7=gym6;
												gym6=gym5;
												gym5=gym4;
												gym4=gym3;
												gym3=gym2;
												gym2=gym1;
												gym=gym1;
												continue;
											}
										}else{
											gym6=gym5;
											gym5=gym4;
											gym4=gym3;
											gym3=gym2;
											gym2=gym1;
											gym=gym1;
											continue;
										}
									}else{
										gym5=gym4;
										gym4=gym3;
										gym3=gym2;
										gym2=gym1;
										gym=gym1;
										continue;
									}
								}else{
									gym4=gym3;
									gym3=gym2;
									gym2=gym1;
									gym=gym1;
									continue;
								}
							}else{
								gym3=gym2;
								gym2=gym1;
								gym=gym1;
								continue;
							}
						}else{
							gym2=gym1;
							gym=gym1;
							continue;
						}
					}
					
				}
				if(gym2!=null){
					if(gym2.getLosses()==0||gym.getLosses()==0){
						gym.addFakeLoss();
						gym2.addFakeLoss();
						if(gym2.getWins()<gym.getWins()){
								if(gym3!=null){
									if(gym4!=null){
										if(gym5!=null){
											if(gym6!=null){
												if(gym7!=null){
													if(gym8!=null){
														if(gym9!=null){
															if(gym10!=null){
																gym10 = gym9;
																gym9=gym8;
																gym8=gym7;
																gym7=gym6;
																gym6=gym5;
																gym5=gym4;
																gym4=gym3;
																gym3=gym2;
																gym2=gym;
																continue;
															}else{
																gym10 = gym9;
																gym9=gym8;
																gym8=gym7;
																gym7=gym6;
																gym6=gym5;
																gym5=gym4;
																gym4=gym3;
																gym3=gym2;
																gym2=gym;
																continue;
															}
														}else{
															gym9=gym8;
															gym8=gym7;
															gym7=gym6;
															gym6=gym5;
															gym5=gym4;
															gym4=gym3;
															gym3=gym2;
															gym2=gym;
															continue;
														}
													}else{
														gym8=gym7;
														gym7=gym6;
														gym6=gym5;
														gym5=gym4;
														gym4=gym3;
														gym3=gym2;
														gym2=gym;
														continue;
													}
												}else{
													gym7=gym6;
													gym6=gym5;
													gym5=gym4;
													gym4=gym3;
													gym3=gym2;
													gym2=gym;
													continue;
												}
											}else{
												gym6=gym5;
												gym5=gym4;
												gym4=gym3;
												gym3=gym2;
												gym2=gym;
												continue;
											}
										}else{
											gym5=gym4;
											gym4=gym3;
											gym3=gym2;
											gym2=gym;
											continue;
										}
									}else{
										gym4=gym3;
										gym3=gym2;
										gym2=gym;
										continue;
									}
								}else{
									gym3=gym2;
									gym2=gym;
									continue;
								}
						}
						
					}
					if((gym2.getWins()/gym2.getLosses())<(gym.getWins()/gym.getLosses())){
						
						gym2.removeFakeLoss();
						if(gym3!=null){
							if(gym4!=null){
								if(gym5!=null){
									if(gym6!=null){
										if(gym7!=null){
											if(gym8!=null){
												if(gym9!=null){
													if(gym10!=null){
														gym10 = gym9;
														gym9=gym8;
														gym8=gym7;
														gym7=gym6;
														gym6=gym5;
														gym5=gym4;
														gym4=gym3;
														gym3=gym2;
														gym2=gym;
														continue;
														}else{
															gym10 = gym9;
															gym9=gym8;
															gym8=gym7;
															gym7=gym6;
															gym6=gym5;
															gym5=gym4;
															gym4=gym3;
															gym3=gym2;
															gym2=gym;
															continue;
														}
													}else{
														gym9=gym8;
														gym8=gym7;
														gym7=gym6;
														gym6=gym5;
														gym5=gym4;
														gym4=gym3;
														gym3=gym2;
														gym2=gym;
														continue;
													}
												}else{
													gym8=gym7;
													gym7=gym6;
													gym6=gym5;
													gym5=gym4;
													gym4=gym3;
													gym3=gym2;
													gym2=gym;
													continue;
												}
											}else{
												gym7=gym6;
												gym6=gym5;
												gym5=gym4;
												gym4=gym3;
												gym3=gym2;
												gym2=gym;
												continue;
											}
										}else{
											gym6=gym5;
											gym5=gym4;
											gym4=gym3;
											gym3=gym2;
											gym2=gym;
											continue;
										}
									}else{
										gym5=gym4;
										gym4=gym3;
										gym3=gym2;
										gym2=gym;
										continue;
									}
								}else{
									gym4=gym3;
									gym3=gym2;
									gym2=gym;
									continue;
								}
							}else{
								gym3=gym2;
								gym2=gym;
								continue;
						}
					}
					
				}
				if(gym3!=null){
					if(gym3.getLosses()==0||gym.getLosses()==0){
						gym.addFakeLoss();
						gym3.addFakeLoss();
						if(gym3.getWins()<gym.getWins()){
									if(gym4!=null){
										if(gym5!=null){
											if(gym6!=null){
												if(gym7!=null){
													if(gym8!=null){
														if(gym9!=null){
															if(gym10!=null){
																gym10 = gym9;
																gym9=gym8;
																gym8=gym7;
																gym7=gym6;
																gym6=gym5;
																gym5=gym4;
																gym4=gym3;
																gym3=gym;
																continue;
															}else{
																gym10 = gym9;
																gym9=gym8;
																gym8=gym7;
																gym7=gym6;
																gym6=gym5;
																gym5=gym4;
																gym4=gym3;
																gym3=gym;
																continue;
															}
														}else{
															gym9=gym8;
															gym8=gym7;
															gym7=gym6;
															gym6=gym5;
															gym5=gym4;
															gym4=gym3;
															gym3=gym;
															continue;
														}
													}else{
														gym8=gym7;
														gym7=gym6;
														gym6=gym5;
														gym5=gym4;
														gym4=gym3;
														gym3=gym;
														continue;
													}
												}else{
													gym7=gym6;
													gym6=gym5;
													gym5=gym4;
													gym4=gym3;
													gym3=gym;
													continue;
												}
											}else{
												gym6=gym5;
												gym5=gym4;
												gym4=gym3;
												gym3=gym;
												continue;
											}
										}else{
											gym5=gym4;
											gym4=gym3;
											gym3=gym;
											continue;
										}
									}else{
										gym4=gym3;
										gym3=gym;
										continue;
									}
						}
						
					}
					if((gym3.getWins()/gym3.getLosses())<(gym.getWins()/gym.getLosses())){
						
						gym3.removeFakeLoss();
							if(gym4!=null){
								if(gym5!=null){
									if(gym6!=null){
										if(gym7!=null){
											if(gym8!=null){
												if(gym9!=null){
													if(gym10!=null){
														gym10 = gym9;
														gym9=gym8;
														gym8=gym7;
														gym7=gym6;
														gym6=gym5;
														gym5=gym4;
														gym4=gym3;
														gym3=gym;
														continue;
														}else{
															gym10 = gym9;
															gym9=gym8;
															gym8=gym7;
															gym7=gym6;
															gym6=gym5;
															gym5=gym4;
															gym4=gym3;
															gym3=gym;
															continue;
														}
													}else{
														gym9=gym8;
														gym8=gym7;
														gym7=gym6;
														gym6=gym5;
														gym5=gym4;
														gym4=gym3;
														gym3=gym;
														continue;
													}
												}else{
													gym8=gym7;
													gym7=gym6;
													gym6=gym5;
													gym5=gym4;
													gym4=gym3;
													gym3=gym;
													continue;
												}
											}else{
												gym7=gym6;
												gym6=gym5;
												gym5=gym4;
												gym4=gym3;
												gym3=gym;
												continue;
											}
										}else{
											gym6=gym5;
											gym5=gym4;
											gym4=gym3;
											gym3=gym;
											continue;
										}
									}else{
										gym5=gym4;
										gym4=gym3;
										gym3=gym;
										continue;
									}
								}else{
									gym4=gym3;
									gym3=gym;
									continue;
								}
					}
					
				}
				if(gym4!=null){
					if(gym4.getLosses()==0||gym.getLosses()==0){
						gym.addFakeLoss();
						gym4.addFakeLoss();
						if(gym4.getWins()<gym.getWins()){
										if(gym5!=null){
											if(gym6!=null){
												if(gym7!=null){
													if(gym8!=null){
														if(gym9!=null){
															if(gym10!=null){
																gym10 = gym9;
																gym9=gym8;
																gym8=gym7;
																gym7=gym6;
																gym6=gym5;
																gym5=gym4;
																gym4=gym;
																continue;
															}else{
																gym10 = gym9;
																gym9=gym8;
																gym8=gym7;
																gym7=gym6;
																gym6=gym5;
																gym5=gym4;
																gym4=gym;
																continue;
															}
														}else{
															gym9=gym8;
															gym8=gym7;
															gym7=gym6;
															gym6=gym5;
															gym5=gym4;
															gym4=gym;
															continue;
														}
													}else{
														gym8=gym7;
														gym7=gym6;
														gym6=gym5;
														gym5=gym4;
														gym4=gym;
														continue;
													}
												}else{
													gym7=gym6;
													gym6=gym5;
													gym5=gym4;
													gym4=gym;
													continue;
												}
											}else{
												gym6=gym5;
												gym5=gym4;
												gym4=gym;
												continue;
											}
										}else{
											gym5=gym4;
											gym4=gym;
											continue;
										}
						}
						
					}
					if((gym4.getWins()/gym4.getLosses())<(gym.getWins()/gym.getLosses())){
						
						gym4.removeFakeLoss();
								if(gym5!=null){
									if(gym6!=null){
										if(gym7!=null){
											if(gym8!=null){
												if(gym9!=null){
													if(gym10!=null){
														gym10 = gym9;
														gym9=gym8;
														gym8=gym7;
														gym7=gym6;
														gym6=gym5;
														gym5=gym4;
														gym4=gym;
														continue;
														}else{
															gym10 = gym9;
															gym9=gym8;
															gym8=gym7;
															gym7=gym6;
															gym6=gym5;
															gym5=gym4;
															gym4=gym;
															continue;
														}
													}else{
														gym9=gym8;
														gym8=gym7;
														gym7=gym6;
														gym6=gym5;
														gym5=gym4;
														gym4=gym;
														continue;
													}
												}else{
													gym8=gym7;
													gym7=gym6;
													gym6=gym5;
													gym5=gym4;
													gym4=gym;
													continue;
												}
											}else{
												gym7=gym6;
												gym6=gym5;
												gym5=gym4;
												gym4=gym;
												continue;
											}
										}else{
											gym6=gym5;
											gym5=gym4;
											gym4=gym;
											continue;
										}
									}else{
										gym5=gym4;
										gym4=gym;
										continue;
									}
					}
					
				}
				if(gym5!=null){
					if(gym5.getLosses()==0||gym.getLosses()==0){
						gym.addFakeLoss();
						gym5.addFakeLoss();
						if(gym5.getWins()<gym.getWins()){
											if(gym6!=null){
												if(gym7!=null){
													if(gym8!=null){
														if(gym9!=null){
															if(gym10!=null){
																gym10 = gym9;
																gym9=gym8;
																gym8=gym7;
																gym7=gym6;
																gym6=gym5;
																gym5=gym;
																continue;
															}else{
																gym10 = gym9;
																gym9=gym8;
																gym8=gym7;
																gym7=gym6;
																gym6=gym5;
																gym5=gym;
																continue;
															}
														}else{
															gym9=gym8;
															gym8=gym7;
															gym7=gym6;
															gym6=gym5;
															gym5=gym;
															continue;
														}
													}else{
														gym8=gym7;
														gym7=gym6;
														gym6=gym5;
														gym5=gym;
														continue;
													}
												}else{
													gym7=gym6;
													gym6=gym5;
													gym5=gym;
													continue;
												}
											}else{
												gym6=gym5;
												gym5=gym;
												continue;
											}
						}
						
					}
					if((gym5.getWins()/gym5.getLosses())<(gym.getWins()/gym.getLosses())){
						
						gym5.removeFakeLoss();
									if(gym6!=null){
										if(gym7!=null){
											if(gym8!=null){
												if(gym9!=null){
													if(gym10!=null){
														gym10 = gym9;
														gym9=gym8;
														gym8=gym7;
														gym7=gym6;
														gym6=gym5;
														gym5=gym;
														continue;
														}else{
															gym10 = gym9;
															gym9=gym8;
															gym8=gym7;
															gym7=gym6;
															gym6=gym5;
															gym5=gym;
															continue;
														}
													}else{
														gym9=gym8;
														gym8=gym7;
														gym7=gym6;
														gym6=gym5;
														gym5=gym;
														continue;
													}
												}else{
													gym8=gym7;
													gym7=gym6;
													gym6=gym5;
													gym5=gym;
													continue;
												}
											}else{
												gym7=gym6;
												gym6=gym5;
												gym5=gym;
												continue;
											}
										}else{
											gym6=gym5;
											gym5=gym;
											continue;
										}
					}
					
				}
				if(gym6!=null){
					if(gym6.getLosses()==0||gym.getLosses()==0){
						gym.addFakeLoss();
						gym6.addFakeLoss();
						if(gym6.getWins()<gym.getWins()){
												if(gym7!=null){
													if(gym8!=null){
														if(gym9!=null){
															if(gym10!=null){
																gym10 = gym9;
																gym9=gym8;
																gym8=gym7;
																gym7=gym6;
																gym6=gym;
																continue;
															}else{
																gym10 = gym9;
																gym9=gym8;
																gym8=gym7;
																gym7=gym6;
																gym6=gym;
																continue;
															}
														}else{
															gym9=gym8;
															gym8=gym7;
															gym7=gym6;
															gym6=gym;
															continue;
														}
													}else{
														gym8=gym7;
														gym7=gym6;
														gym6=gym;
														continue;
													}
												}else{
													gym7=gym6;
													gym6=gym;
													continue;
												}
						}
						
					}
					if((gym6.getWins()/gym6.getLosses())<(gym.getWins()/gym.getLosses())){
						
						gym6.removeFakeLoss();
										if(gym7!=null){
											if(gym8!=null){
												if(gym9!=null){
													if(gym10!=null){
														gym10 = gym9;
														gym9=gym8;
														gym8=gym7;
														gym7=gym6;
														gym6=gym;
														continue;
														}else{
															gym10 = gym9;
															gym9=gym8;
															gym8=gym7;
															gym7=gym6;
															gym6=gym;
															continue;
														}
													}else{
														gym9=gym8;
														gym8=gym7;
														gym7=gym6;
														gym6=gym;
														continue;
													}
												}else{
													gym8=gym7;
													gym7=gym6;
													gym6=gym;
													continue;
												}
											}else{
												gym7=gym6;
												gym6=gym;
												continue;
											}
					}
					
				}
				if(gym7!=null){
					if(gym7.getLosses()==0||gym.getLosses()==0){
						gym.addFakeLoss();
						gym7.addFakeLoss();
						if(gym7.getWins()<gym.getWins()){
													if(gym8!=null){
														if(gym9!=null){
															if(gym10!=null){
																gym10 = gym9;
																gym9=gym8;
																gym8=gym7;
																gym7=gym;
																continue;
															}else{
																gym10 = gym9;
																gym9=gym8;
																gym8=gym7;
																gym7=gym;
																continue;
															}
														}else{
															gym9=gym8;
															gym8=gym7;
															gym7=gym;
															continue;
														}
													}else{
														gym8=gym7;
														gym7=gym;
														continue;
													}
						}
						
					}
					if((gym7.getWins()/gym7.getLosses())<(gym.getWins()/gym.getLosses())){
						
						gym7.removeFakeLoss();
											if(gym8!=null){
												if(gym9!=null){
													if(gym10!=null){
														gym10 = gym9;
														gym9=gym8;
														gym8=gym7;
														gym7=gym;
														continue;
														}else{
															gym10 = gym9;
															gym9=gym8;
															gym8=gym7;
															gym7=gym;
															continue;
														}
													}else{
														gym9=gym8;
														gym8=gym7;
														gym7=gym;
														continue;
													}
												}else{
													gym8=gym7;
													gym7=gym;
													continue;
												}
					}
					
				}
				if(gym8!=null){
					if(gym8.getLosses()==0||gym.getLosses()==0){
						gym.addFakeLoss();
						gym8.addFakeLoss();
						if(gym8.getWins()<gym.getWins()){
														if(gym9!=null){
															if(gym10!=null){
																gym10 = gym9;
																gym9=gym8;
																gym8=gym;
																continue;
															}else{
																gym10 = gym9;
																gym9=gym8;
																gym8=gym;
																continue;
															}
														}else{
															gym9=gym8;
															gym8=gym;
															continue;
														}
						}
						
					}
					if((gym8.getWins()/gym8.getLosses())<(gym.getWins()/gym.getLosses())){
						
						gym8.removeFakeLoss();
												if(gym9!=null){
													if(gym10!=null){
														gym10 = gym9;
														gym9=gym8;
														gym8=gym;
														continue;
														}else{
															gym10 = gym9;
															gym9=gym8;
															gym8=gym;
															continue;
														}
													}else{
														gym9=gym8;
														gym8=gym;
														continue;
													}
					}
					
				}
				if(gym9!=null){
					if(gym9.getLosses()==0||gym.getLosses()==0){
						gym.addFakeLoss();
						gym9.addFakeLoss();
						if(gym9.getWins()<gym.getWins()){
															if(gym10!=null){
																gym10 = gym9;
																gym9=gym;
																continue;
															}else{
																gym10 = gym9;
																gym9=gym;
																continue;
															}
						}
						
					}
					if((gym9.getWins()/gym9.getLosses())<(gym.getWins()/gym.getLosses())){
						
						gym9.removeFakeLoss();
													if(gym10!=null){
														gym10 = gym9;
														gym9=gym;
														continue;
														}else{
															gym10 = gym9;
															gym9=gym;
															continue;
														}
					}
					
				}
				if(gym10!=null){
					if(gym10.getLosses()==0||gym.getLosses()==0){
						gym.addFakeLoss();
						gym10.addFakeLoss();
						if(gym10.getWins()<gym.getWins()){
																gym10 = gym;
																continue;
						}
						
					}
					if((gym10.getWins()/gym10.getLosses())<(gym.getWins()/gym.getLosses())){
						
						gym10.removeFakeLoss();
														gym10 = gym;
														continue;
					}
					
				}
				gym1=gym;
				
			}
			if(gym10!=null){
				if(gym1.getLosses()==0){
					gym1.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",TextColors.LIGHT_PURPLE,"Type: ",gym1.getType()," ",TextColors.GREEN,"Leader: ",gym1.getOwner(), TextColors.RED," Wins: ",gym1.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym1.getWins()));
				}else
					gym1.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"1: ",TextColors.LIGHT_PURPLE,"Type: ",gym1.getType()," ",TextColors.GREEN,"Leader: ",gym1.getOwner(), TextColors.RED," Wins: ",gym1.getWins()," Losses: ",gym1.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym1.getWins()/gym1.getLosses()));
				if(gym2.getLosses()==0){
					gym2.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",TextColors.LIGHT_PURPLE,"Type: ",gym2.getType()," ",TextColors.GREEN,"Leader: ",gym2.getOwner(), TextColors.RED," Wins: ",gym2.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym2.getWins()));
				}else
					gym2.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"2: ",TextColors.LIGHT_PURPLE,"Type: ",gym2.getType()," ",TextColors.GREEN,"Leader: ",gym2.getOwner(), TextColors.RED," Wins: ",gym2.getWins()," Losses: ",gym2.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym2.getWins()/gym2.getLosses()));
				if(gym3.getLosses()==0){
					gym3.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"3: ",TextColors.LIGHT_PURPLE,"Type: ",gym3.getType()," ",TextColors.GREEN,"Leader: ",gym3.getOwner(), TextColors.RED," Wins: ",gym3.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym3.getWins()));
				}else
					gym3.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"3: ",TextColors.LIGHT_PURPLE,"Type: ",gym3.getType()," ",TextColors.GREEN,"Leader: ",gym3.getOwner(), TextColors.RED," Wins: ",gym3.getWins()," Losses: ",gym3.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym3.getWins()/gym3.getLosses()));
				if(gym4.getLosses()==0){
					gym4.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"4: ",TextColors.LIGHT_PURPLE,"Type: ",gym4.getType()," ",TextColors.GREEN,"Leader: ",gym4.getOwner(), TextColors.RED," Wins: ",gym4.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym4.getWins()));
				}else
					gym4.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"4: ",TextColors.LIGHT_PURPLE,"Type: ",gym4.getType()," ",TextColors.GREEN,"Leader: ",gym4.getOwner(), TextColors.RED," Wins: ",gym4.getWins()," Losses: ",gym4.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym4.getWins()/gym4.getLosses()));
				if(gym5.getLosses()==0){
					gym5.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"5: ",TextColors.LIGHT_PURPLE,"Type: ",gym5.getType()," ",TextColors.GREEN,"Leader: ",gym5.getOwner(), TextColors.RED," Wins: ",gym5.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym5.getWins()));
				}else
					gym5.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"5: ",TextColors.LIGHT_PURPLE,"Type: ",gym5.getType()," ",TextColors.GREEN,"Leader: ",gym5.getOwner(), TextColors.RED," Wins: ",gym5.getWins()," Losses: ",gym5.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym5.getWins()/gym5.getLosses()));
				if(gym6.getLosses()==0){
					gym6.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"6: ",TextColors.LIGHT_PURPLE,"Type: ",gym6.getType()," ",TextColors.GREEN,"Leader: ",gym6.getOwner(), TextColors.RED," Wins: ",gym6.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym6.getWins()));
				}else
					gym6.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"6: ",TextColors.LIGHT_PURPLE,"Type: ",gym6.getType()," ",TextColors.GREEN,"Leader: ",gym6.getOwner(), TextColors.RED," Wins: ",gym6.getWins()," Losses: ",gym6.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym6.getWins()/gym6.getLosses()));
				if(gym7.getLosses()==0){
					gym7.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"7: ",TextColors.LIGHT_PURPLE,"Type: ",gym7.getType()," ",TextColors.GREEN,"Leader: ",gym7.getOwner(), TextColors.RED," Wins: ",gym7.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym7.getWins()));
				}else
					gym7.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"7: ",TextColors.LIGHT_PURPLE,"Type: ",gym7.getType()," ",TextColors.GREEN,"Leader: ",gym7.getOwner(), TextColors.RED," Wins: ",gym7.getWins()," Losses: ",gym7.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym7.getWins()/gym7.getLosses()));
				if(gym8.getLosses()==0){
					gym8.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"8: ",TextColors.LIGHT_PURPLE,"Type: ",gym8.getType()," ",TextColors.GREEN,"Leader: ",gym8.getOwner(), TextColors.RED," Wins: ",gym8.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym8.getWins()));
				}else
					gym8.removeFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"8: ",TextColors.LIGHT_PURPLE,"Type: ",gym8.getType()," ",TextColors.GREEN,"Leader: ",gym8.getOwner(), TextColors.RED," Wins: ",gym8.getWins()," Losses: ",gym8.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym8.getWins()/gym8.getLosses()));
				if(gym9.getLosses()==0){
					gym9.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"9: ",TextColors.LIGHT_PURPLE,"Type: ",gym9.getType()," ",TextColors.GREEN,"Leader: ",gym9.getOwner(), TextColors.RED," Wins: ",gym9.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym9.getWins()));
				}else
					gym9.removeFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"9: ",TextColors.LIGHT_PURPLE,"Type: ",gym9.getType()," ",TextColors.GREEN,"Leader: ",gym9.getOwner(), TextColors.RED," Wins: ",gym9.getWins()," Losses: ",gym9.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym9.getWins()/gym9.getLosses()));
				if(gym10.getLosses()==0){
					gym10.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"10: ",TextColors.LIGHT_PURPLE,"Type: ",gym10.getType()," ",TextColors.GREEN,"Leader: ",gym10.getOwner(), TextColors.RED," Wins: ",gym10.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym10.getWins()));
				}else
					gym10.removeFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"10: ",TextColors.LIGHT_PURPLE,"Type: ",gym10.getType()," ",TextColors.GREEN,"Leader: ",gym10.getOwner(), TextColors.RED," Wins: ",gym10.getWins()," Losses: ",gym10.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym10.getWins()/gym10.getLosses()));
				gym1.removeFakeLoss();
				gym2.removeFakeLoss();
				gym3.removeFakeLoss();
				gym4.removeFakeLoss();
				gym5.removeFakeLoss();
				gym6.removeFakeLoss();
				gym7.removeFakeLoss();
				gym8.removeFakeLoss();
				gym9.removeFakeLoss();
				gym10.removeFakeLoss();
				return CommandResult.successCount(0);
			}
			if(gym9!=null){
				if(gym1.getLosses()==0){
					gym1.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",TextColors.LIGHT_PURPLE,"Type: ",gym1.getType()," ",TextColors.GREEN,"Leader: ",gym1.getOwner(), TextColors.RED," Wins: ",gym1.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym1.getWins()));
				}else
					gym1.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"1: ",TextColors.LIGHT_PURPLE,"Type: ",gym1.getType()," ",TextColors.GREEN,"Leader: ",gym1.getOwner(), TextColors.RED," Wins: ",gym1.getWins()," Losses: ",gym1.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym1.getWins()/gym1.getLosses()));
				if(gym2.getLosses()==0){
					gym2.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",TextColors.LIGHT_PURPLE,"Type: ",gym2.getType()," ",TextColors.GREEN,"Leader: ",gym2.getOwner(), TextColors.RED," Wins: ",gym2.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym2.getWins()));
				}else
					gym2.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"2: ",TextColors.LIGHT_PURPLE,"Type: ",gym2.getType()," ",TextColors.GREEN,"Leader: ",gym2.getOwner(), TextColors.RED," Wins: ",gym2.getWins()," Losses: ",gym2.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym2.getWins()/gym2.getLosses()));
				if(gym3.getLosses()==0){
					gym3.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"3: ",TextColors.LIGHT_PURPLE,"Type: ",gym3.getType()," ",TextColors.GREEN,"Leader: ",gym3.getOwner(), TextColors.RED," Wins: ",gym3.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym3.getWins()));
				}else
					gym3.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"3: ",TextColors.LIGHT_PURPLE,"Type: ",gym3.getType()," ",TextColors.GREEN,"Leader: ",gym3.getOwner(), TextColors.RED," Wins: ",gym3.getWins()," Losses: ",gym3.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym3.getWins()/gym3.getLosses()));
				if(gym4.getLosses()==0){
					gym4.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"4: ",TextColors.LIGHT_PURPLE,"Type: ",gym4.getType()," ",TextColors.GREEN,"Leader: ",gym4.getOwner(), TextColors.RED," Wins: ",gym4.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym4.getWins()));
				}else
					gym4.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"4: ",TextColors.LIGHT_PURPLE,"Type: ",gym4.getType()," ",TextColors.GREEN,"Leader: ",gym4.getOwner(), TextColors.RED," Wins: ",gym4.getWins()," Losses: ",gym4.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym4.getWins()/gym4.getLosses()));
				if(gym5.getLosses()==0){
					gym5.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"5: ",TextColors.LIGHT_PURPLE,"Type: ",gym5.getType()," ",TextColors.GREEN,"Leader: ",gym5.getOwner(), TextColors.RED," Wins: ",gym5.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym5.getWins()));
				}else
					gym5.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"5: ",TextColors.LIGHT_PURPLE,"Type: ",gym5.getType()," ",TextColors.GREEN,"Leader: ",gym5.getOwner(), TextColors.RED," Wins: ",gym5.getWins()," Losses: ",gym5.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym5.getWins()/gym5.getLosses()));
				if(gym6.getLosses()==0){
					gym6.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"6: ",TextColors.LIGHT_PURPLE,"Type: ",gym6.getType()," ",TextColors.GREEN,"Leader: ",gym6.getOwner(), TextColors.RED," Wins: ",gym6.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym6.getWins()));
				}else
					gym6.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"6: ",TextColors.LIGHT_PURPLE,"Type: ",gym6.getType()," ",TextColors.GREEN,"Leader: ",gym6.getOwner(), TextColors.RED," Wins: ",gym6.getWins()," Losses: ",gym6.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym6.getWins()/gym6.getLosses()));
				if(gym7.getLosses()==0){
					gym7.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"7: ",TextColors.LIGHT_PURPLE,"Type: ",gym7.getType()," ",TextColors.GREEN,"Leader: ",gym7.getOwner(), TextColors.RED," Wins: ",gym7.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym7.getWins()));
				}else
					gym7.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"7: ",TextColors.LIGHT_PURPLE,"Type: ",gym7.getType()," ",TextColors.GREEN,"Leader: ",gym7.getOwner(), TextColors.RED," Wins: ",gym7.getWins()," Losses: ",gym7.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym7.getWins()/gym7.getLosses()));
				if(gym8.getLosses()==0){
					gym8.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"8: ",TextColors.LIGHT_PURPLE,"Type: ",gym8.getType()," ",TextColors.GREEN,"Leader: ",gym8.getOwner(), TextColors.RED," Wins: ",gym8.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym8.getWins()));
				}else
					gym8.removeFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"8: ",TextColors.LIGHT_PURPLE,"Type: ",gym8.getType()," ",TextColors.GREEN,"Leader: ",gym8.getOwner(), TextColors.RED," Wins: ",gym8.getWins()," Losses: ",gym8.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym8.getWins()/gym8.getLosses()));
				if(gym9.getLosses()==0){
					gym9.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"9: ",TextColors.LIGHT_PURPLE,"Type: ",gym9.getType()," ",TextColors.GREEN,"Leader: ",gym9.getOwner(), TextColors.RED," Wins: ",gym9.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym9.getWins()));
				}else
					gym9.removeFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"9: ",TextColors.LIGHT_PURPLE,"Type: ",gym9.getType()," ",TextColors.GREEN,"Leader: ",gym9.getOwner(), TextColors.RED," Wins: ",gym9.getWins()," Losses: ",gym9.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym9.getWins()/gym9.getLosses()));
				gym1.removeFakeLoss();
				gym2.removeFakeLoss();
				gym3.removeFakeLoss();
				gym4.removeFakeLoss();
				gym5.removeFakeLoss();
				gym6.removeFakeLoss();
				gym7.removeFakeLoss();
				gym8.removeFakeLoss();
				gym9.removeFakeLoss();
				return CommandResult.successCount(1);
			}
			if(gym8!=null){
				if(gym1.getLosses()==0){
					gym1.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",TextColors.LIGHT_PURPLE,"Type: ",gym1.getType()," ",TextColors.GREEN,"Leader: ",gym1.getOwner(), TextColors.RED," Wins: ",gym1.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym1.getWins()));
				}else
					gym1.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"1: ",TextColors.LIGHT_PURPLE,"Type: ",gym1.getType()," ",TextColors.GREEN,"Leader: ",gym1.getOwner(), TextColors.RED," Wins: ",gym1.getWins()," Losses: ",gym1.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym1.getWins()/gym1.getLosses()));
				if(gym2.getLosses()==0){
					gym2.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",TextColors.LIGHT_PURPLE,"Type: ",gym2.getType()," ",TextColors.GREEN,"Leader: ",gym2.getOwner(), TextColors.RED," Wins: ",gym2.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym2.getWins()));
				}else
					gym2.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"2: ",TextColors.LIGHT_PURPLE,"Type: ",gym2.getType()," ",TextColors.GREEN,"Leader: ",gym2.getOwner(), TextColors.RED," Wins: ",gym2.getWins()," Losses: ",gym2.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym2.getWins()/gym2.getLosses()));
				if(gym3.getLosses()==0){
					gym3.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"3: ",TextColors.LIGHT_PURPLE,"Type: ",gym3.getType()," ",TextColors.GREEN,"Leader: ",gym3.getOwner(), TextColors.RED," Wins: ",gym3.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym3.getWins()));
				}else
					gym3.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"3: ",TextColors.LIGHT_PURPLE,"Type: ",gym3.getType()," ",TextColors.GREEN,"Leader: ",gym3.getOwner(), TextColors.RED," Wins: ",gym3.getWins()," Losses: ",gym3.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym3.getWins()/gym3.getLosses()));
				if(gym4.getLosses()==0){
					gym4.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"4: ",TextColors.LIGHT_PURPLE,"Type: ",gym4.getType()," ",TextColors.GREEN,"Leader: ",gym4.getOwner(), TextColors.RED," Wins: ",gym4.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym4.getWins()));
				}else
					gym4.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"4: ",TextColors.LIGHT_PURPLE,"Type: ",gym4.getType()," ",TextColors.GREEN,"Leader: ",gym4.getOwner(), TextColors.RED," Wins: ",gym4.getWins()," Losses: ",gym4.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym4.getWins()/gym4.getLosses()));
				if(gym5.getLosses()==0){
					gym5.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"5: ",TextColors.LIGHT_PURPLE,"Type: ",gym5.getType()," ",TextColors.GREEN,"Leader: ",gym5.getOwner(), TextColors.RED," Wins: ",gym5.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym5.getWins()));
				}else
					gym5.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"5: ",TextColors.LIGHT_PURPLE,"Type: ",gym5.getType()," ",TextColors.GREEN,"Leader: ",gym5.getOwner(), TextColors.RED," Wins: ",gym5.getWins()," Losses: ",gym5.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym5.getWins()/gym5.getLosses()));
				if(gym6.getLosses()==0){
					gym6.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"6: ",TextColors.LIGHT_PURPLE,"Type: ",gym6.getType()," ",TextColors.GREEN,"Leader: ",gym6.getOwner(), TextColors.RED," Wins: ",gym6.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym6.getWins()));
				}else
					gym6.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"6: ",TextColors.LIGHT_PURPLE,"Type: ",gym6.getType()," ",TextColors.GREEN,"Leader: ",gym6.getOwner(), TextColors.RED," Wins: ",gym6.getWins()," Losses: ",gym6.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym6.getWins()/gym6.getLosses()));
				if(gym7.getLosses()==0){
					gym7.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"7: ",TextColors.LIGHT_PURPLE,"Type: ",gym7.getType()," ",TextColors.GREEN,"Leader: ",gym7.getOwner(), TextColors.RED," Wins: ",gym7.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym7.getWins()));
				}else
					gym7.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"7: ",TextColors.LIGHT_PURPLE,"Type: ",gym7.getType()," ",TextColors.GREEN,"Leader: ",gym7.getOwner(), TextColors.RED," Wins: ",gym7.getWins()," Losses: ",gym7.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym7.getWins()/gym7.getLosses()));
				if(gym8.getLosses()==0){
					gym8.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"8: ",TextColors.LIGHT_PURPLE,"Type: ",gym8.getType()," ",TextColors.GREEN,"Leader: ",gym8.getOwner(), TextColors.RED," Wins: ",gym8.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym8.getWins()));
				}else
					gym8.removeFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"8: ",TextColors.LIGHT_PURPLE,"Type: ",gym8.getType()," ",TextColors.GREEN,"Leader: ",gym8.getOwner(), TextColors.RED," Wins: ",gym8.getWins()," Losses: ",gym8.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym8.getWins()/gym8.getLosses()));
				gym1.removeFakeLoss();
				gym2.removeFakeLoss();
				gym3.removeFakeLoss();
				gym4.removeFakeLoss();
				gym5.removeFakeLoss();
				gym6.removeFakeLoss();
				gym7.removeFakeLoss();
				gym8.removeFakeLoss();
				return CommandResult.successCount(2);
			}
			if(gym7!=null){
				if(gym1.getLosses()==0){
					gym1.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",TextColors.LIGHT_PURPLE,"Type: ",gym1.getType()," ",TextColors.GREEN,"Leader: ",gym1.getOwner(), TextColors.RED," Wins: ",gym1.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym1.getWins()));
				}else
					gym1.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"1: ",TextColors.LIGHT_PURPLE,"Type: ",gym1.getType()," ",TextColors.GREEN,"Leader: ",gym1.getOwner(), TextColors.RED," Wins: ",gym1.getWins()," Losses: ",gym1.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym1.getWins()/gym1.getLosses()));
				if(gym2.getLosses()==0){
					gym2.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",TextColors.LIGHT_PURPLE,"Type: ",gym2.getType()," ",TextColors.GREEN,"Leader: ",gym2.getOwner(), TextColors.RED," Wins: ",gym2.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym2.getWins()));
				}else
					gym2.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"2: ",TextColors.LIGHT_PURPLE,"Type: ",gym2.getType()," ",TextColors.GREEN,"Leader: ",gym2.getOwner(), TextColors.RED," Wins: ",gym2.getWins()," Losses: ",gym2.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym2.getWins()/gym2.getLosses()));
				if(gym3.getLosses()==0){
					gym3.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"3: ",TextColors.LIGHT_PURPLE,"Type: ",gym3.getType()," ",TextColors.GREEN,"Leader: ",gym3.getOwner(), TextColors.RED," Wins: ",gym3.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym3.getWins()));
				}else
					gym3.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"3: ",TextColors.LIGHT_PURPLE,"Type: ",gym3.getType()," ",TextColors.GREEN,"Leader: ",gym3.getOwner(), TextColors.RED," Wins: ",gym3.getWins()," Losses: ",gym3.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym3.getWins()/gym3.getLosses()));
				if(gym4.getLosses()==0){
					gym4.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"4: ",TextColors.LIGHT_PURPLE,"Type: ",gym4.getType()," ",TextColors.GREEN,"Leader: ",gym4.getOwner(), TextColors.RED," Wins: ",gym4.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym4.getWins()));
				}else
					gym4.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"4: ",TextColors.LIGHT_PURPLE,"Type: ",gym4.getType()," ",TextColors.GREEN,"Leader: ",gym4.getOwner(), TextColors.RED," Wins: ",gym4.getWins()," Losses: ",gym4.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym4.getWins()/gym4.getLosses()));
				if(gym5.getLosses()==0){
					gym5.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"5: ",TextColors.LIGHT_PURPLE,"Type: ",gym5.getType()," ",TextColors.GREEN,"Leader: ",gym5.getOwner(), TextColors.RED," Wins: ",gym5.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym5.getWins()));
				}else
					gym5.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"5: ",TextColors.LIGHT_PURPLE,"Type: ",gym5.getType()," ",TextColors.GREEN,"Leader: ",gym5.getOwner(), TextColors.RED," Wins: ",gym5.getWins()," Losses: ",gym5.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym5.getWins()/gym5.getLosses()));
				if(gym6.getLosses()==0){
					gym6.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"6: ",TextColors.LIGHT_PURPLE,"Type: ",gym6.getType()," ",TextColors.GREEN,"Leader: ",gym6.getOwner(), TextColors.RED," Wins: ",gym6.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym6.getWins()));
				}else
					gym6.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"6: ",TextColors.LIGHT_PURPLE,"Type: ",gym6.getType()," ",TextColors.GREEN,"Leader: ",gym6.getOwner(), TextColors.RED," Wins: ",gym6.getWins()," Losses: ",gym6.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym6.getWins()/gym6.getLosses()));
				if(gym7.getLosses()==0){
					gym7.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"7: ",TextColors.LIGHT_PURPLE,"Type: ",gym7.getType()," ",TextColors.GREEN,"Leader: ",gym7.getOwner(), TextColors.RED," Wins: ",gym7.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym7.getWins()));
				}else
					gym7.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"7: ",TextColors.LIGHT_PURPLE,"Type: ",gym7.getType()," ",TextColors.GREEN,"Leader: ",gym7.getOwner(), TextColors.RED," Wins: ",gym7.getWins()," Losses: ",gym7.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym7.getWins()/gym7.getLosses()));
				gym1.removeFakeLoss();
				gym2.removeFakeLoss();
				gym3.removeFakeLoss();
				gym4.removeFakeLoss();
				gym5.removeFakeLoss();
				gym6.removeFakeLoss();
				gym7.removeFakeLoss();
				return CommandResult.successCount(3);
			}
			if(gym6!=null){
				if(gym1.getLosses()==0){
					gym1.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",TextColors.LIGHT_PURPLE,"Type: ",gym1.getType()," ",TextColors.GREEN,"Leader: ",gym1.getOwner(), TextColors.RED," Wins: ",gym1.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym1.getWins()));
				}else
					gym1.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"1: ",TextColors.LIGHT_PURPLE,"Type: ",gym1.getType()," ",TextColors.GREEN,"Leader: ",gym1.getOwner(), TextColors.RED," Wins: ",gym1.getWins()," Losses: ",gym1.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym1.getWins()/gym1.getLosses()));
				if(gym2.getLosses()==0){
					gym2.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",TextColors.LIGHT_PURPLE,"Type: ",gym2.getType()," ",TextColors.GREEN,"Leader: ",gym2.getOwner(), TextColors.RED," Wins: ",gym2.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym2.getWins()));
				}else
					gym2.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"2: ",TextColors.LIGHT_PURPLE,"Type: ",gym2.getType()," ",TextColors.GREEN,"Leader: ",gym2.getOwner(), TextColors.RED," Wins: ",gym2.getWins()," Losses: ",gym2.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym2.getWins()/gym2.getLosses()));
				if(gym3.getLosses()==0){
					gym3.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"3: ",TextColors.LIGHT_PURPLE,"Type: ",gym3.getType()," ",TextColors.GREEN,"Leader: ",gym3.getOwner(), TextColors.RED," Wins: ",gym3.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym3.getWins()));
				}else
					gym3.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"3: ",TextColors.LIGHT_PURPLE,"Type: ",gym3.getType()," ",TextColors.GREEN,"Leader: ",gym3.getOwner(), TextColors.RED," Wins: ",gym3.getWins()," Losses: ",gym3.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym3.getWins()/gym3.getLosses()));
				if(gym4.getLosses()==0){
					gym4.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"4: ",TextColors.LIGHT_PURPLE,"Type: ",gym4.getType()," ",TextColors.GREEN,"Leader: ",gym4.getOwner(), TextColors.RED," Wins: ",gym4.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym4.getWins()));
				}else
					gym4.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"4: ",TextColors.LIGHT_PURPLE,"Type: ",gym4.getType()," ",TextColors.GREEN,"Leader: ",gym4.getOwner(), TextColors.RED," Wins: ",gym4.getWins()," Losses: ",gym4.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym4.getWins()/gym4.getLosses()));
				if(gym5.getLosses()==0){
					gym5.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"5: ",TextColors.LIGHT_PURPLE,"Type: ",gym5.getType()," ",TextColors.GREEN,"Leader: ",gym5.getOwner(), TextColors.RED," Wins: ",gym5.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym5.getWins()));
				}else
					gym5.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"5: ",TextColors.LIGHT_PURPLE,"Type: ",gym5.getType()," ",TextColors.GREEN,"Leader: ",gym5.getOwner(), TextColors.RED," Wins: ",gym5.getWins()," Losses: ",gym5.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym5.getWins()/gym5.getLosses()));
				if(gym6.getLosses()==0){
					gym6.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"6: ",TextColors.LIGHT_PURPLE,"Type: ",gym6.getType()," ",TextColors.GREEN,"Leader: ",gym6.getOwner(), TextColors.RED," Wins: ",gym6.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym6.getWins()));
				}else
					gym6.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"6: ",TextColors.LIGHT_PURPLE,"Type: ",gym6.getType()," ",TextColors.GREEN,"Leader: ",gym6.getOwner(), TextColors.RED," Wins: ",gym6.getWins()," Losses: ",gym6.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym6.getWins()/gym6.getLosses()));
				gym1.removeFakeLoss();
				gym2.removeFakeLoss();
				gym3.removeFakeLoss();
				gym4.removeFakeLoss();
				gym5.removeFakeLoss();
				gym6.removeFakeLoss();
				return CommandResult.successCount(4);
			}
			if(gym5!=null){
				if(gym1.getLosses()==0){
					gym1.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",TextColors.LIGHT_PURPLE,"Type: ",gym1.getType()," ",TextColors.GREEN,"Leader: ",gym1.getOwner(), TextColors.RED," Wins: ",gym1.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym1.getWins()));
				}else
					gym1.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"1: ",TextColors.LIGHT_PURPLE,"Type: ",gym1.getType()," ",TextColors.GREEN,"Leader: ",gym1.getOwner(), TextColors.RED," Wins: ",gym1.getWins()," Losses: ",gym1.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym1.getWins()/gym1.getLosses()));
				if(gym2.getLosses()==0){
					gym2.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",TextColors.LIGHT_PURPLE,"Type: ",gym2.getType()," ",TextColors.GREEN,"Leader: ",gym2.getOwner(), TextColors.RED," Wins: ",gym2.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym2.getWins()));
				}else
					gym2.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"2: ",TextColors.LIGHT_PURPLE,"Type: ",gym2.getType()," ",TextColors.GREEN,"Leader: ",gym2.getOwner(), TextColors.RED," Wins: ",gym2.getWins()," Losses: ",gym2.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym2.getWins()/gym2.getLosses()));
				if(gym3.getLosses()==0){
					gym3.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"3: ",TextColors.LIGHT_PURPLE,"Type: ",gym3.getType()," ",TextColors.GREEN,"Leader: ",gym3.getOwner(), TextColors.RED," Wins: ",gym3.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym3.getWins()));
				}else
					gym3.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"3: ",TextColors.LIGHT_PURPLE,"Type: ",gym3.getType()," ",TextColors.GREEN,"Leader: ",gym3.getOwner(), TextColors.RED," Wins: ",gym3.getWins()," Losses: ",gym3.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym3.getWins()/gym3.getLosses()));
				if(gym4.getLosses()==0){
					gym4.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"4: ",TextColors.LIGHT_PURPLE,"Type: ",gym4.getType()," ",TextColors.GREEN,"Leader: ",gym4.getOwner(), TextColors.RED," Wins: ",gym4.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym4.getWins()));
				}else
					gym4.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"4: ",TextColors.LIGHT_PURPLE,"Type: ",gym4.getType()," ",TextColors.GREEN,"Leader: ",gym4.getOwner(), TextColors.RED," Wins: ",gym4.getWins()," Losses: ",gym4.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym4.getWins()/gym4.getLosses()));
				if(gym5.getLosses()==0){
					gym5.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"5: ",TextColors.LIGHT_PURPLE,"Type: ",gym5.getType()," ",TextColors.GREEN,"Leader: ",gym5.getOwner(), TextColors.RED," Wins: ",gym5.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym5.getWins()));
				}else
					gym5.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"5: ",TextColors.LIGHT_PURPLE,"Type: ",gym5.getType()," ",TextColors.GREEN,"Leader: ",gym5.getOwner(), TextColors.RED," Wins: ",gym5.getWins()," Losses: ",gym5.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym5.getWins()/gym5.getLosses()));
				gym1.removeFakeLoss();
				gym2.removeFakeLoss();
				gym3.removeFakeLoss();
				gym4.removeFakeLoss();
				gym5.removeFakeLoss();
				return CommandResult.successCount(5);
			}
			if(gym4!=null){
				if(gym1.getLosses()==0){
					gym1.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",TextColors.LIGHT_PURPLE,"Type: ",gym1.getType()," ",TextColors.GREEN,"Leader: ",gym1.getOwner(), TextColors.RED," Wins: ",gym1.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym1.getWins()));
				}else
					gym1.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"1: ",TextColors.LIGHT_PURPLE,"Type: ",gym1.getType()," ",TextColors.GREEN,"Leader: ",gym1.getOwner(), TextColors.RED," Wins: ",gym1.getWins()," Losses: ",gym1.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym1.getWins()/gym1.getLosses()));
				if(gym2.getLosses()==0){
					gym2.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",TextColors.LIGHT_PURPLE,"Type: ",gym2.getType()," ",TextColors.GREEN,"Leader: ",gym2.getOwner(), TextColors.RED," Wins: ",gym2.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym2.getWins()));
				}else
					gym2.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"2: ",TextColors.LIGHT_PURPLE,"Type: ",gym2.getType()," ",TextColors.GREEN,"Leader: ",gym2.getOwner(), TextColors.RED," Wins: ",gym2.getWins()," Losses: ",gym2.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym2.getWins()/gym2.getLosses()));
				if(gym3.getLosses()==0){
					gym3.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"3: ",TextColors.LIGHT_PURPLE,"Type: ",gym3.getType()," ",TextColors.GREEN,"Leader: ",gym3.getOwner(), TextColors.RED," Wins: ",gym3.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym3.getWins()));
				}else
					gym3.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"3: ",TextColors.LIGHT_PURPLE,"Type: ",gym3.getType()," ",TextColors.GREEN,"Leader: ",gym3.getOwner(), TextColors.RED," Wins: ",gym3.getWins()," Losses: ",gym3.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym3.getWins()/gym3.getLosses()));
				if(gym4.getLosses()==0){
					gym4.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"4: ",TextColors.LIGHT_PURPLE,"Type: ",gym4.getType()," ",TextColors.GREEN,"Leader: ",gym4.getOwner(), TextColors.RED," Wins: ",gym4.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym4.getWins()));
				}else
					gym4.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"4: ",TextColors.LIGHT_PURPLE,"Type: ",gym4.getType()," ",TextColors.GREEN,"Leader: ",gym4.getOwner(), TextColors.RED," Wins: ",gym4.getWins()," Losses: ",gym4.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym4.getWins()/gym4.getLosses()));
				gym1.removeFakeLoss();
				gym2.removeFakeLoss();
				gym3.removeFakeLoss();
				gym4.removeFakeLoss();
				return CommandResult.successCount(6);
			}
			if(gym3!=null){
				if(gym1.getLosses()==0){
					gym1.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",TextColors.LIGHT_PURPLE,"Type: ",gym1.getType()," ",TextColors.GREEN,"Leader: ",gym1.getOwner(), TextColors.RED," Wins: ",gym1.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym1.getWins()));
				}else
					gym1.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"1: ",TextColors.LIGHT_PURPLE,"Type: ",gym1.getType()," ",TextColors.GREEN,"Leader: ",gym1.getOwner(), TextColors.RED," Wins: ",gym1.getWins()," Losses: ",gym1.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym1.getWins()/gym1.getLosses()));
				if(gym2.getLosses()==0){
					gym2.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",TextColors.LIGHT_PURPLE,"Type: ",gym2.getType()," ",TextColors.GREEN,"Leader: ",gym2.getOwner(), TextColors.RED," Wins: ",gym2.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym2.getWins()));
				}else
					gym2.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"2: ",TextColors.LIGHT_PURPLE,"Type: ",gym2.getType()," ",TextColors.GREEN,"Leader: ",gym2.getOwner(), TextColors.RED," Wins: ",gym2.getWins()," Losses: ",gym2.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym2.getWins()/gym2.getLosses()));
				if(gym3.getLosses()==0){
					gym3.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"3: ",TextColors.LIGHT_PURPLE,"Type: ",gym3.getType()," ",TextColors.GREEN,"Leader: ",gym3.getOwner(), TextColors.RED," Wins: ",gym3.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym3.getWins()));
				}else
					gym3.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"3: ",TextColors.LIGHT_PURPLE,"Type: ",gym3.getType()," ",TextColors.GREEN,"Leader: ",gym3.getOwner(), TextColors.RED," Wins: ",gym3.getWins()," Losses: ",gym3.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym3.getWins()/gym3.getLosses()));
				gym1.removeFakeLoss();
				gym2.removeFakeLoss();
				gym3.removeFakeLoss();
				return CommandResult.successCount(7);
			}
			if(gym2!=null){
				if(gym1.getLosses()==0){
					gym1.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",TextColors.LIGHT_PURPLE,"Type: ",gym1.getType()," ",TextColors.GREEN,"Leader: ",gym1.getOwner(), TextColors.RED," Wins: ",gym1.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym1.getWins()));
				}else
					gym1.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"1: ",TextColors.LIGHT_PURPLE,"Type: ",gym1.getType()," ",TextColors.GREEN,"Leader: ",gym1.getOwner(), TextColors.RED," Wins: ",gym1.getWins()," Losses: ",gym1.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym1.getWins()/gym1.getLosses()));
				if(gym2.getLosses()==0){
					gym2.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",TextColors.LIGHT_PURPLE,"Type: ",gym2.getType()," ",TextColors.GREEN,"Leader: ",gym2.getOwner(), TextColors.RED," Wins: ",gym2.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym2.getWins()));
				}else
					gym2.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"2: ",TextColors.LIGHT_PURPLE,"Type: ",gym2.getType()," ",TextColors.GREEN,"Leader: ",gym2.getOwner(), TextColors.RED," Wins: ",gym2.getWins()," Losses: ",gym2.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym2.getWins()/gym2.getLosses()));
				gym1.removeFakeLoss();
				gym2.removeFakeLoss();
				return CommandResult.successCount(8);
			}
			if(gym1!=null){
				if(gym1.getLosses()==0){
					gym1.addFakeLoss();
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",TextColors.LIGHT_PURPLE,"Type: ",gym1.getType()," ",TextColors.GREEN,"Leader: ",gym1.getOwner(), TextColors.RED," Wins: ",gym1.getWins()," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",gym1.getWins()));
				}else
					gym1.removeFakeLoss(); p.sendMessage(Text.of(TextColors.GOLD,"1: ",TextColors.LIGHT_PURPLE,"Type: ",gym1.getType()," ",TextColors.GREEN,"Leader: ",gym1.getOwner(), TextColors.RED," Wins: ",gym1.getWins()," Losses: ",gym1.getLosses(),TextColors.DARK_GREEN," W/L Ratio: ",gym1.getWins()/gym1.getLosses()));
				gym1.removeFakeLoss();
				return CommandResult.successCount(9);
			}
			p.sendMessage(Text.of(TextColors.GOLD,"There Are No Gyms!"));
			
		}
		return CommandResult.success();
	}
}
