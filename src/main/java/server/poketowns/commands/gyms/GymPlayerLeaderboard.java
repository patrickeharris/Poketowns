package server.poketowns.commands.gyms;

import org.spongepowered.api.Sponge;
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

public class GymPlayerLeaderboard implements CommandExecutor{
	//prevent undefined
	public CommandResult execute(CommandSource source, CommandContext context) throws CommandException {
		if(source instanceof Player){
			Player p = (Player) source;
			if(GymManager.getInstance().getPlayers()==null){
				p.sendMessage(Text.of(TextColors.RED,TextStyles.BOLD,"There Are No Players!"));
				return CommandResult.successCount(9);
			}
			String gym1 = null;
			String gym2 = null;
			String gym3 = null;
			String gym4 = null;
			String gym5 = null;
			String gym6 = null;
			String gym7 = null;
			String gym8 = null;
			String gym9 = null;
			String gym10 = null;
			p.sendMessage(Text.of(TextStyles.BOLD,TextColors.BLUE,"Top 10 Players:"));
			for(String gym:GymManager.getInstance().getPlayers()){
				if(GymManager.getInstance().getLosses(gym)==0){
					GymManager.getInstance().addFakeLoss(gym);
				}
				if(gym1!=null){
					if(GymManager.getInstance().getLosses(gym1)==0||GymManager.getInstance().getLosses(gym)==0){
						if(GymManager.getInstance().getWins(gym1)<GymManager.getInstance().getWins(gym)){
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
																GymManager.getInstance().removeFakeLoss(gym); continue;
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
																GymManager.getInstance().removeFakeLoss(gym); continue;
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
															GymManager.getInstance().removeFakeLoss(gym); continue;
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
														GymManager.getInstance().removeFakeLoss(gym); continue;
													}
												}else{
													gym7=gym6;
													gym6=gym5;
													gym5=gym4;
													gym4=gym3;
													gym3=gym2;
													gym2=gym1;
													gym=gym1;
													GymManager.getInstance().removeFakeLoss(gym); continue;
												}
											}else{
												gym6=gym5;
												gym5=gym4;
												gym4=gym3;
												gym3=gym2;
												gym2=gym1;
												gym=gym1;
												GymManager.getInstance().removeFakeLoss(gym); continue;
											}
										}else{
											gym5=gym4;
											gym4=gym3;
											gym3=gym2;
											gym2=gym1;
											gym=gym1;
											GymManager.getInstance().removeFakeLoss(gym); continue;
										}
									}else{
										gym4=gym3;
										gym3=gym2;
										gym2=gym1;
										gym=gym1;
										GymManager.getInstance().removeFakeLoss(gym); continue;
									}
								}else{
									gym3=gym2;
									gym2=gym1;
									gym=gym1;
									GymManager.getInstance().removeFakeLoss(gym); continue;
								}
							}else{
								gym2=gym1;
								gym=gym1;
								GymManager.getInstance().removeFakeLoss(gym); continue;
							}
						}
						GymManager.getInstance().removeFakeLoss(gym);
					}
					if((GymManager.getInstance().getWins(gym1)/GymManager.getInstance().getLosses(gym1))<(GymManager.getInstance().getWins(gym)/GymManager.getInstance().getLosses(gym))){
						GymManager.getInstance().removeFakeLoss(gym);
						GymManager.getInstance().removeFakeLoss(gym1);
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
															GymManager.getInstance().removeFakeLoss(gym); continue;
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
															GymManager.getInstance().removeFakeLoss(gym); continue;
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
														GymManager.getInstance().removeFakeLoss(gym); continue;
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
													GymManager.getInstance().removeFakeLoss(gym); continue;
												}
											}else{
												gym7=gym6;
												gym6=gym5;
												gym5=gym4;
												gym4=gym3;
												gym3=gym2;
												gym2=gym1;
												gym=gym1;
												GymManager.getInstance().removeFakeLoss(gym); continue;
											}
										}else{
											gym6=gym5;
											gym5=gym4;
											gym4=gym3;
											gym3=gym2;
											gym2=gym1;
											gym=gym1;
											GymManager.getInstance().removeFakeLoss(gym); continue;
										}
									}else{
										gym5=gym4;
										gym4=gym3;
										gym3=gym2;
										gym2=gym1;
										gym=gym1;
										GymManager.getInstance().removeFakeLoss(gym); continue;
									}
								}else{
									gym4=gym3;
									gym3=gym2;
									gym2=gym1;
									gym=gym1;
									GymManager.getInstance().removeFakeLoss(gym); continue;
								}
							}else{
								gym3=gym2;
								gym2=gym1;
								gym=gym1;
								GymManager.getInstance().removeFakeLoss(gym); continue;
							}
						}else{
							gym2=gym1;
							gym=gym1;
							GymManager.getInstance().removeFakeLoss(gym); continue;
						}
					}
					GymManager.getInstance().removeFakeLoss(gym);
				}
				if(gym2!=null){
					if(GymManager.getInstance().getLosses(gym2)==0||GymManager.getInstance().getLosses(gym)==0){
						if(GymManager.getInstance().getWins(gym2)<GymManager.getInstance().getWins(gym)){
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
																GymManager.getInstance().removeFakeLoss(gym); continue;
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
																GymManager.getInstance().removeFakeLoss(gym); continue;
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
															GymManager.getInstance().removeFakeLoss(gym); continue;
														}
													}else{
														gym8=gym7;
														gym7=gym6;
														gym6=gym5;
														gym5=gym4;
														gym4=gym3;
														gym3=gym2;
														gym2=gym;
														GymManager.getInstance().removeFakeLoss(gym); continue;
													}
												}else{
													gym7=gym6;
													gym6=gym5;
													gym5=gym4;
													gym4=gym3;
													gym3=gym2;
													gym2=gym;
													GymManager.getInstance().removeFakeLoss(gym); continue;
												}
											}else{
												gym6=gym5;
												gym5=gym4;
												gym4=gym3;
												gym3=gym2;
												gym2=gym;
												GymManager.getInstance().removeFakeLoss(gym); continue;
											}
										}else{
											gym5=gym4;
											gym4=gym3;
											gym3=gym2;
											gym2=gym;
											GymManager.getInstance().removeFakeLoss(gym); continue;
										}
									}else{
										gym4=gym3;
										gym3=gym2;
										gym2=gym;
										GymManager.getInstance().removeFakeLoss(gym); continue;
									}
								}else{
									gym3=gym2;
									gym2=gym;
									GymManager.getInstance().removeFakeLoss(gym); continue;
								}
						}
						GymManager.getInstance().removeFakeLoss(gym);
					}
					if((GymManager.getInstance().getWins(gym2)/GymManager.getInstance().getLosses(gym2))<(GymManager.getInstance().getWins(gym)/GymManager.getInstance().getLosses(gym))){
						GymManager.getInstance().removeFakeLoss(gym);
						GymManager.getInstance().removeFakeLoss(gym2);
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
														GymManager.getInstance().removeFakeLoss(gym); continue;
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
															GymManager.getInstance().removeFakeLoss(gym); continue;
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
														GymManager.getInstance().removeFakeLoss(gym); continue;
													}
												}else{
													gym8=gym7;
													gym7=gym6;
													gym6=gym5;
													gym5=gym4;
													gym4=gym3;
													gym3=gym2;
													gym2=gym;
													GymManager.getInstance().removeFakeLoss(gym); continue;
												}
											}else{
												gym7=gym6;
												gym6=gym5;
												gym5=gym4;
												gym4=gym3;
												gym3=gym2;
												gym2=gym;
												GymManager.getInstance().removeFakeLoss(gym); continue;
											}
										}else{
											gym6=gym5;
											gym5=gym4;
											gym4=gym3;
											gym3=gym2;
											gym2=gym;
											GymManager.getInstance().removeFakeLoss(gym); continue;
										}
									}else{
										gym5=gym4;
										gym4=gym3;
										gym3=gym2;
										gym2=gym;
										GymManager.getInstance().removeFakeLoss(gym); continue;
									}
								}else{
									gym4=gym3;
									gym3=gym2;
									gym2=gym;
									GymManager.getInstance().removeFakeLoss(gym); continue;
								}
							}else{
								gym3=gym2;
								gym2=gym;
								GymManager.getInstance().removeFakeLoss(gym); continue;
						}
					}
					GymManager.getInstance().removeFakeLoss(gym);
				}
				if(gym3!=null){
					if(GymManager.getInstance().getLosses(gym3)==0||GymManager.getInstance().getLosses(gym)==0){
						if(GymManager.getInstance().getWins(gym3)<GymManager.getInstance().getWins(gym)){
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
																GymManager.getInstance().removeFakeLoss(gym); continue;
															}else{
																gym10 = gym9;
																gym9=gym8;
																gym8=gym7;
																gym7=gym6;
																gym6=gym5;
																gym5=gym4;
																gym4=gym3;
																gym3=gym;
																GymManager.getInstance().removeFakeLoss(gym); continue;
															}
														}else{
															gym9=gym8;
															gym8=gym7;
															gym7=gym6;
															gym6=gym5;
															gym5=gym4;
															gym4=gym3;
															gym3=gym;
															GymManager.getInstance().removeFakeLoss(gym); continue;
														}
													}else{
														gym8=gym7;
														gym7=gym6;
														gym6=gym5;
														gym5=gym4;
														gym4=gym3;
														gym3=gym;
														GymManager.getInstance().removeFakeLoss(gym); continue;
													}
												}else{
													gym7=gym6;
													gym6=gym5;
													gym5=gym4;
													gym4=gym3;
													gym3=gym;
													GymManager.getInstance().removeFakeLoss(gym); continue;
												}
											}else{
												gym6=gym5;
												gym5=gym4;
												gym4=gym3;
												gym3=gym;
												GymManager.getInstance().removeFakeLoss(gym); continue;
											}
										}else{
											gym5=gym4;
											gym4=gym3;
											gym3=gym;
											GymManager.getInstance().removeFakeLoss(gym); continue;
										}
									}else{
										gym4=gym3;
										gym3=gym;
										GymManager.getInstance().removeFakeLoss(gym); continue;
									}
						}
						GymManager.getInstance().removeFakeLoss(gym);
					}
					if((GymManager.getInstance().getWins(gym3)/GymManager.getInstance().getLosses(gym3))<(GymManager.getInstance().getWins(gym)/GymManager.getInstance().getLosses(gym))){
						GymManager.getInstance().removeFakeLoss(gym);
						GymManager.getInstance().removeFakeLoss(gym3);	
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
														GymManager.getInstance().removeFakeLoss(gym); continue;
														}else{
															gym10 = gym9;
															gym9=gym8;
															gym8=gym7;
															gym7=gym6;
															gym6=gym5;
															gym5=gym4;
															gym4=gym3;
															gym3=gym;
															GymManager.getInstance().removeFakeLoss(gym); continue;
														}
													}else{
														gym9=gym8;
														gym8=gym7;
														gym7=gym6;
														gym6=gym5;
														gym5=gym4;
														gym4=gym3;
														gym3=gym;
														GymManager.getInstance().removeFakeLoss(gym); continue;
													}
												}else{
													gym8=gym7;
													gym7=gym6;
													gym6=gym5;
													gym5=gym4;
													gym4=gym3;
													gym3=gym;
													GymManager.getInstance().removeFakeLoss(gym); continue;
												}
											}else{
												gym7=gym6;
												gym6=gym5;
												gym5=gym4;
												gym4=gym3;
												gym3=gym;
												GymManager.getInstance().removeFakeLoss(gym); continue;
											}
										}else{
											gym6=gym5;
											gym5=gym4;
											gym4=gym3;
											gym3=gym;
											GymManager.getInstance().removeFakeLoss(gym); continue;
										}
									}else{
										gym5=gym4;
										gym4=gym3;
										gym3=gym;
										GymManager.getInstance().removeFakeLoss(gym); continue;
									}
								}else{
									gym4=gym3;
									gym3=gym;
									GymManager.getInstance().removeFakeLoss(gym); continue;
								}
					}
					GymManager.getInstance().removeFakeLoss(gym);
				}
				if(gym4!=null){
					if(GymManager.getInstance().getLosses(gym4)==0||GymManager.getInstance().getLosses(gym)==0){
						if(GymManager.getInstance().getWins(gym4)<GymManager.getInstance().getWins(gym)){
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
																GymManager.getInstance().removeFakeLoss(gym); continue;
															}else{
																gym10 = gym9;
																gym9=gym8;
																gym8=gym7;
																gym7=gym6;
																gym6=gym5;
																gym5=gym4;
																gym4=gym;
																GymManager.getInstance().removeFakeLoss(gym); continue;
															}
														}else{
															gym9=gym8;
															gym8=gym7;
															gym7=gym6;
															gym6=gym5;
															gym5=gym4;
															gym4=gym;
															GymManager.getInstance().removeFakeLoss(gym); continue;
														}
													}else{
														gym8=gym7;
														gym7=gym6;
														gym6=gym5;
														gym5=gym4;
														gym4=gym;
														GymManager.getInstance().removeFakeLoss(gym); continue;
													}
												}else{
													gym7=gym6;
													gym6=gym5;
													gym5=gym4;
													gym4=gym;
													GymManager.getInstance().removeFakeLoss(gym); continue;
												}
											}else{
												gym6=gym5;
												gym5=gym4;
												gym4=gym;
												GymManager.getInstance().removeFakeLoss(gym); continue;
											}
										}else{
											gym5=gym4;
											gym4=gym;
											GymManager.getInstance().removeFakeLoss(gym); continue;
										}
						}
						GymManager.getInstance().removeFakeLoss(gym);
					}
					if((GymManager.getInstance().getWins(gym4)/GymManager.getInstance().getLosses(gym4))<(GymManager.getInstance().getWins(gym)/GymManager.getInstance().getLosses(gym))){
						GymManager.getInstance().removeFakeLoss(gym);
						GymManager.getInstance().removeFakeLoss(gym4);		
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
														GymManager.getInstance().removeFakeLoss(gym); continue;
														}else{
															gym10 = gym9;
															gym9=gym8;
															gym8=gym7;
															gym7=gym6;
															gym6=gym5;
															gym5=gym4;
															gym4=gym;
															GymManager.getInstance().removeFakeLoss(gym); continue;
														}
													}else{
														gym9=gym8;
														gym8=gym7;
														gym7=gym6;
														gym6=gym5;
														gym5=gym4;
														gym4=gym;
														GymManager.getInstance().removeFakeLoss(gym); continue;
													}
												}else{
													gym8=gym7;
													gym7=gym6;
													gym6=gym5;
													gym5=gym4;
													gym4=gym;
													GymManager.getInstance().removeFakeLoss(gym); continue;
												}
											}else{
												gym7=gym6;
												gym6=gym5;
												gym5=gym4;
												gym4=gym;
												GymManager.getInstance().removeFakeLoss(gym); continue;
											}
										}else{
											gym6=gym5;
											gym5=gym4;
											gym4=gym;
											GymManager.getInstance().removeFakeLoss(gym); continue;
										}
									}else{
										gym5=gym4;
										gym4=gym;
										GymManager.getInstance().removeFakeLoss(gym); continue;
									}
					}
					GymManager.getInstance().removeFakeLoss(gym);
				}
				if(gym5!=null){
					if(GymManager.getInstance().getLosses(gym5)==0||GymManager.getInstance().getLosses(gym)==0){
						if(GymManager.getInstance().getWins(gym5)<GymManager.getInstance().getWins(gym)){
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
																GymManager.getInstance().removeFakeLoss(gym); continue;
															}else{
																gym10 = gym9;
																gym9=gym8;
																gym8=gym7;
																gym7=gym6;
																gym6=gym5;
																gym5=gym;
																GymManager.getInstance().removeFakeLoss(gym); continue;
															}
														}else{
															gym9=gym8;
															gym8=gym7;
															gym7=gym6;
															gym6=gym5;
															gym5=gym;
															GymManager.getInstance().removeFakeLoss(gym); continue;
														}
													}else{
														gym8=gym7;
														gym7=gym6;
														gym6=gym5;
														gym5=gym;
														GymManager.getInstance().removeFakeLoss(gym); continue;
													}
												}else{
													gym7=gym6;
													gym6=gym5;
													gym5=gym;
													GymManager.getInstance().removeFakeLoss(gym); continue;
												}
											}else{
												gym6=gym5;
												gym5=gym;
												GymManager.getInstance().removeFakeLoss(gym); continue;
											}
						}
						GymManager.getInstance().removeFakeLoss(gym);
					}
					if((GymManager.getInstance().getWins(gym5)/GymManager.getInstance().getLosses(gym5))<(GymManager.getInstance().getWins(gym)/GymManager.getInstance().getLosses(gym))){
						GymManager.getInstance().removeFakeLoss(gym);
						GymManager.getInstance().removeFakeLoss(gym5);			
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
														GymManager.getInstance().removeFakeLoss(gym); continue;
														}else{
															gym10 = gym9;
															gym9=gym8;
															gym8=gym7;
															gym7=gym6;
															gym6=gym5;
															gym5=gym;
															GymManager.getInstance().removeFakeLoss(gym); continue;
														}
													}else{
														gym9=gym8;
														gym8=gym7;
														gym7=gym6;
														gym6=gym5;
														gym5=gym;
														GymManager.getInstance().removeFakeLoss(gym); continue;
													}
												}else{
													gym8=gym7;
													gym7=gym6;
													gym6=gym5;
													gym5=gym;
													GymManager.getInstance().removeFakeLoss(gym); continue;
												}
											}else{
												gym7=gym6;
												gym6=gym5;
												gym5=gym;
												GymManager.getInstance().removeFakeLoss(gym); continue;
											}
										}else{
											gym6=gym5;
											gym5=gym;
											GymManager.getInstance().removeFakeLoss(gym); continue;
										}
					}
					GymManager.getInstance().removeFakeLoss(gym);
				}
				if(gym6!=null){
					if(GymManager.getInstance().getLosses(gym6)==0||GymManager.getInstance().getLosses(gym)==0){
						if(GymManager.getInstance().getWins(gym6)<GymManager.getInstance().getWins(gym)){
												if(gym7!=null){
													if(gym8!=null){
														if(gym9!=null){
															if(gym10!=null){
																gym10 = gym9;
																gym9=gym8;
																gym8=gym7;
																gym7=gym6;
																gym6=gym;
																GymManager.getInstance().removeFakeLoss(gym); continue;
															}else{
																gym10 = gym9;
																gym9=gym8;
																gym8=gym7;
																gym7=gym6;
																gym6=gym;
																GymManager.getInstance().removeFakeLoss(gym); continue;
															}
														}else{
															gym9=gym8;
															gym8=gym7;
															gym7=gym6;
															gym6=gym;
															GymManager.getInstance().removeFakeLoss(gym); continue;
														}
													}else{
														gym8=gym7;
														gym7=gym6;
														gym6=gym;
														GymManager.getInstance().removeFakeLoss(gym); continue;
													}
												}else{
													gym7=gym6;
													gym6=gym;
													GymManager.getInstance().removeFakeLoss(gym); continue;
												}
						}
						GymManager.getInstance().removeFakeLoss(gym);
					}
					if((GymManager.getInstance().getWins(gym6)/GymManager.getInstance().getLosses(gym6))<(GymManager.getInstance().getWins(gym)/GymManager.getInstance().getLosses(gym))){
						GymManager.getInstance().removeFakeLoss(gym);
						GymManager.getInstance().removeFakeLoss(gym6);				
						if(gym7!=null){
											if(gym8!=null){
												if(gym9!=null){
													if(gym10!=null){
														gym10 = gym9;
														gym9=gym8;
														gym8=gym7;
														gym7=gym6;
														gym6=gym;
														GymManager.getInstance().removeFakeLoss(gym); continue;
														}else{
															gym10 = gym9;
															gym9=gym8;
															gym8=gym7;
															gym7=gym6;
															gym6=gym;
															GymManager.getInstance().removeFakeLoss(gym); continue;
														}
													}else{
														gym9=gym8;
														gym8=gym7;
														gym7=gym6;
														gym6=gym;
														GymManager.getInstance().removeFakeLoss(gym); continue;
													}
												}else{
													gym8=gym7;
													gym7=gym6;
													gym6=gym;
													GymManager.getInstance().removeFakeLoss(gym); continue;
												}
											}else{
												gym7=gym6;
												gym6=gym;
												GymManager.getInstance().removeFakeLoss(gym); continue;
											}
					}
					GymManager.getInstance().removeFakeLoss(gym);
				}
				if(gym7!=null){
					if(GymManager.getInstance().getLosses(gym7)==0||GymManager.getInstance().getLosses(gym)==0){
						if(GymManager.getInstance().getWins(gym7)<GymManager.getInstance().getWins(gym)){
													if(gym8!=null){
														if(gym9!=null){
															if(gym10!=null){
																gym10 = gym9;
																gym9=gym8;
																gym8=gym7;
																gym7=gym;
																GymManager.getInstance().removeFakeLoss(gym); continue;
															}else{
																gym10 = gym9;
																gym9=gym8;
																gym8=gym7;
																gym7=gym;
																GymManager.getInstance().removeFakeLoss(gym); continue;
															}
														}else{
															gym9=gym8;
															gym8=gym7;
															gym7=gym;
															GymManager.getInstance().removeFakeLoss(gym); continue;
														}
													}else{
														gym8=gym7;
														gym7=gym;
														GymManager.getInstance().removeFakeLoss(gym); continue;
													}
						}
						GymManager.getInstance().removeFakeLoss(gym);
					}
					if((GymManager.getInstance().getWins(gym7)/GymManager.getInstance().getLosses(gym7))<(GymManager.getInstance().getWins(gym)/GymManager.getInstance().getLosses(gym))){
						GymManager.getInstance().removeFakeLoss(gym);
						GymManager.getInstance().removeFakeLoss(gym7);
						if(gym8!=null){
												if(gym9!=null){
													if(gym10!=null){
														gym10 = gym9;
														gym9=gym8;
														gym8=gym7;
														gym7=gym;
														GymManager.getInstance().removeFakeLoss(gym); continue;
														}else{
															gym10 = gym9;
															gym9=gym8;
															gym8=gym7;
															gym7=gym;
															GymManager.getInstance().removeFakeLoss(gym); continue;
														}
													}else{
														gym9=gym8;
														gym8=gym7;
														gym7=gym;
														GymManager.getInstance().removeFakeLoss(gym); continue;
													}
												}else{
													gym8=gym7;
													gym7=gym;
													GymManager.getInstance().removeFakeLoss(gym); continue;
												}
					}
					GymManager.getInstance().removeFakeLoss(gym);
				}
				if(gym8!=null){
					if(GymManager.getInstance().getLosses(gym8)==0||GymManager.getInstance().getLosses(gym)==0){
						if(GymManager.getInstance().getWins(gym8)<GymManager.getInstance().getWins(gym)){
														if(gym9!=null){
															if(gym10!=null){
																gym10 = gym9;
																gym9=gym8;
																gym8=gym;
																GymManager.getInstance().removeFakeLoss(gym); continue;
															}else{
																gym10 = gym9;
																gym9=gym8;
																gym8=gym;
																GymManager.getInstance().removeFakeLoss(gym); continue;
															}
														}else{
															gym9=gym8;
															gym8=gym;
															GymManager.getInstance().removeFakeLoss(gym); continue;
														}
						}
						GymManager.getInstance().removeFakeLoss(gym);
					}
					if((GymManager.getInstance().getWins(gym8)/GymManager.getInstance().getLosses(gym8))<(GymManager.getInstance().getWins(gym)/GymManager.getInstance().getLosses(gym))){
						GymManager.getInstance().removeFakeLoss(gym);
						GymManager.getInstance().removeFakeLoss(gym8);					
						if(gym9!=null){
													if(gym10!=null){
														gym10 = gym9;
														gym9=gym8;
														gym8=gym;
														GymManager.getInstance().removeFakeLoss(gym); continue;
														}else{
															gym10 = gym9;
															gym9=gym8;
															gym8=gym;
															GymManager.getInstance().removeFakeLoss(gym); continue;
														}
													}else{
														gym9=gym8;
														gym8=gym;
														GymManager.getInstance().removeFakeLoss(gym); continue;
													}
					}
					GymManager.getInstance().removeFakeLoss(gym);
				}
				if(gym9!=null){
					if(GymManager.getInstance().getLosses(gym9)==0||GymManager.getInstance().getLosses(gym)==0){
						if(GymManager.getInstance().getWins(gym9)<GymManager.getInstance().getWins(gym)){
															if(gym10!=null){
																gym10 = gym9;
																gym9=gym;
																GymManager.getInstance().removeFakeLoss(gym); continue;
															}else{
																gym10 = gym9;
																gym9=gym;
																GymManager.getInstance().removeFakeLoss(gym); continue;
															}
						}
						GymManager.getInstance().removeFakeLoss(gym);
					}
					if((GymManager.getInstance().getWins(gym9)/GymManager.getInstance().getLosses(gym9))<(GymManager.getInstance().getWins(gym)/GymManager.getInstance().getLosses(gym))){
						GymManager.getInstance().removeFakeLoss(gym);
						GymManager.getInstance().removeFakeLoss(gym9);						
						if(gym10!=null){
														gym10 = gym9;
														gym9=gym;
														GymManager.getInstance().removeFakeLoss(gym); continue;
														}else{
															gym10 = gym9;
															gym9=gym;
															GymManager.getInstance().removeFakeLoss(gym); continue;
														}
					}
					GymManager.getInstance().removeFakeLoss(gym);
				}
				if(gym10!=null){
					if(GymManager.getInstance().getLosses(gym10)==0||GymManager.getInstance().getLosses(gym)==0){
						if(GymManager.getInstance().getWins(gym10)<GymManager.getInstance().getWins(gym)){
																gym10 = gym;
																GymManager.getInstance().removeFakeLoss(gym); continue;
						}
						GymManager.getInstance().removeFakeLoss(gym);
					}
					if((GymManager.getInstance().getWins(gym10)/GymManager.getInstance().getLosses(gym10))<(GymManager.getInstance().getWins(gym)/GymManager.getInstance().getLosses(gym))){
						GymManager.getInstance().removeFakeLoss(gym);
						GymManager.getInstance().removeFakeLoss(gym10);		
						gym10 = gym;
														GymManager.getInstance().removeFakeLoss(gym); continue;
					}
					GymManager.getInstance().removeFakeLoss(gym);
				}
				gym1=gym;
				GymManager.getInstance().removeFakeLoss(gym);
			}
			if(gym10!=null){
				if(GymManager.getInstance().getLosses(gym1)==null||GymManager.getInstance().getLosses(gym1)==0){
					GymManager.getInstance().addFakeLoss(gym1);
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",gym1, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym1)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym1)/GymManager.getInstance().getLosses(gym1)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",gym1, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym1)," Losses: ",GymManager.getInstance().getLosses(gym1),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym1)/GymManager.getInstance().getLosses(gym1)));
				if(GymManager.getInstance().getLosses(gym2)==null||GymManager.getInstance().getLosses(gym2)==0){
					GymManager.getInstance().addFakeLoss(gym2);
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",gym2, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym2)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym2)/GymManager.getInstance().getLosses(gym2)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",gym2, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym2)," Losses: ",GymManager.getInstance().getLosses(gym2),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym2)/GymManager.getInstance().getLosses(gym2)));
				if(GymManager.getInstance().getLosses(gym3)==null||GymManager.getInstance().getLosses(gym3)==0){
					GymManager.getInstance().addFakeLoss(gym3);
					p.sendMessage(Text.of(TextColors.GOLD,"3: ",gym3, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym3)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym3)/GymManager.getInstance().getLosses(gym3)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"3: ",gym3, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym3)," Losses: ",GymManager.getInstance().getLosses(gym3),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym3)/GymManager.getInstance().getLosses(gym3)));
				if(GymManager.getInstance().getLosses(gym4)==null||GymManager.getInstance().getLosses(gym4)==0){
					GymManager.getInstance().addFakeLoss(gym4);
					p.sendMessage(Text.of(TextColors.GOLD,"4: ",gym4, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym4)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym4)/GymManager.getInstance().getLosses(gym4)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"4: ",gym4, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym4)," Losses: ",GymManager.getInstance().getLosses(gym4),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym4)/GymManager.getInstance().getLosses(gym4)));
				if(GymManager.getInstance().getLosses(gym5)==null||GymManager.getInstance().getLosses(gym5)==0){
					GymManager.getInstance().addFakeLoss(gym5);
					p.sendMessage(Text.of(TextColors.GOLD,"5: ",gym5, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym5)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym5)/GymManager.getInstance().getLosses(gym5)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"5: ",gym5, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym5)," Losses: ",GymManager.getInstance().getLosses(gym5),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym5)/GymManager.getInstance().getLosses(gym5)));
				if(GymManager.getInstance().getLosses(gym6)==null||GymManager.getInstance().getLosses(gym6)==0){
					GymManager.getInstance().addFakeLoss(gym6);
					p.sendMessage(Text.of(TextColors.GOLD,"6: ",gym6, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym6)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym6)/GymManager.getInstance().getLosses(gym6)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"6: ",gym6, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym6)," Losses: ",GymManager.getInstance().getLosses(gym6),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym6)/GymManager.getInstance().getLosses(gym6)));
				if(GymManager.getInstance().getLosses(gym7)==null||GymManager.getInstance().getLosses(gym7)==0){
					GymManager.getInstance().addFakeLoss(gym7);
					p.sendMessage(Text.of(TextColors.GOLD,"7: ",gym7, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym7)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym7)/GymManager.getInstance().getLosses(gym7)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"7: ",gym7, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym7)," Losses: ",GymManager.getInstance().getLosses(gym7),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym7)/GymManager.getInstance().getLosses(gym7)));
				if(GymManager.getInstance().getLosses(gym8)==null||GymManager.getInstance().getLosses(gym8)==0){
					GymManager.getInstance().addFakeLoss(gym8);
					p.sendMessage(Text.of(TextColors.GOLD,"8: ",gym8, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym8)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym8)/GymManager.getInstance().getLosses(gym8)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"8: ",gym8, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym8)," Losses: ",GymManager.getInstance().getLosses(gym8),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym8)/GymManager.getInstance().getLosses(gym8)));
				if(GymManager.getInstance().getLosses(gym9)==null||GymManager.getInstance().getLosses(gym9)==0){
					GymManager.getInstance().addFakeLoss(gym9);
					p.sendMessage(Text.of(TextColors.GOLD,"9: ",gym9, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym9)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym9)/GymManager.getInstance().getLosses(gym9)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"9: ",gym9, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym9)," Losses: ",GymManager.getInstance().getLosses(gym9),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym9)/GymManager.getInstance().getLosses(gym9)));
				if(GymManager.getInstance().getLosses(gym10)==null||GymManager.getInstance().getLosses(gym10)==0){
					GymManager.getInstance().addFakeLoss(gym10);
					p.sendMessage(Text.of(TextColors.GOLD,"10: ",gym10, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym10)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym10)/GymManager.getInstance().getLosses(gym10)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"10: ",gym10, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym10)," Losses: ",GymManager.getInstance().getLosses(gym10),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym10)/GymManager.getInstance().getLosses(gym10)));
				GymManager.getInstance().removeFakeLoss(gym1);
				GymManager.getInstance().removeFakeLoss(gym2);
				GymManager.getInstance().removeFakeLoss(gym3);
				GymManager.getInstance().removeFakeLoss(gym4);
				GymManager.getInstance().removeFakeLoss(gym5);
				GymManager.getInstance().removeFakeLoss(gym6);
				GymManager.getInstance().removeFakeLoss(gym7);
				GymManager.getInstance().removeFakeLoss(gym8);
				GymManager.getInstance().removeFakeLoss(gym9);
				GymManager.getInstance().removeFakeLoss(gym10);
				return CommandResult.successCount(0);
			}
			if(gym9!=null){
				if(GymManager.getInstance().getLosses(gym1)==null||GymManager.getInstance().getLosses(gym1)==0){
					GymManager.getInstance().addFakeLoss(gym1);
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",gym1, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym1)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym1)/GymManager.getInstance().getLosses(gym1)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",gym1, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym1)," Losses: ",GymManager.getInstance().getLosses(gym1),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym1)/GymManager.getInstance().getLosses(gym1)));
				if(GymManager.getInstance().getLosses(gym2)==null||GymManager.getInstance().getLosses(gym2)==0){
					GymManager.getInstance().addFakeLoss(gym2);
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",gym2, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym2)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym2)/GymManager.getInstance().getLosses(gym2)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",gym2, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym2)," Losses: ",GymManager.getInstance().getLosses(gym2),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym2)/GymManager.getInstance().getLosses(gym2)));
				if(GymManager.getInstance().getLosses(gym3)==null||GymManager.getInstance().getLosses(gym3)==0){
					GymManager.getInstance().addFakeLoss(gym3);
					p.sendMessage(Text.of(TextColors.GOLD,"3: ",gym3, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym3)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym3)/GymManager.getInstance().getLosses(gym3)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"3: ",gym3, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym3)," Losses: ",GymManager.getInstance().getLosses(gym3),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym3)/GymManager.getInstance().getLosses(gym3)));
				if(GymManager.getInstance().getLosses(gym4)==null||GymManager.getInstance().getLosses(gym4)==0){
					GymManager.getInstance().addFakeLoss(gym4);
					p.sendMessage(Text.of(TextColors.GOLD,"4: ",gym4, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym4)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym4)/GymManager.getInstance().getLosses(gym4)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"4: ",gym4, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym4)," Losses: ",GymManager.getInstance().getLosses(gym4),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym4)/GymManager.getInstance().getLosses(gym4)));
				if(GymManager.getInstance().getLosses(gym5)==null||GymManager.getInstance().getLosses(gym5)==0){
					GymManager.getInstance().addFakeLoss(gym5);
					p.sendMessage(Text.of(TextColors.GOLD,"5: ",gym5, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym5)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym5)/GymManager.getInstance().getLosses(gym5)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"5: ",gym5, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym5)," Losses: ",GymManager.getInstance().getLosses(gym5),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym5)/GymManager.getInstance().getLosses(gym5)));
				if(GymManager.getInstance().getLosses(gym6)==null||GymManager.getInstance().getLosses(gym6)==0){
					GymManager.getInstance().addFakeLoss(gym6);
					p.sendMessage(Text.of(TextColors.GOLD,"6: ",gym6, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym6)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym6)/GymManager.getInstance().getLosses(gym6)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"6: ",gym6, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym6)," Losses: ",GymManager.getInstance().getLosses(gym6),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym6)/GymManager.getInstance().getLosses(gym6)));
				if(GymManager.getInstance().getLosses(gym7)==null||GymManager.getInstance().getLosses(gym7)==0){
					GymManager.getInstance().addFakeLoss(gym7);
					p.sendMessage(Text.of(TextColors.GOLD,"7: ",gym7, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym7)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym7)/GymManager.getInstance().getLosses(gym7)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"7: ",gym7, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym7)," Losses: ",GymManager.getInstance().getLosses(gym7),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym7)/GymManager.getInstance().getLosses(gym7)));
				if(GymManager.getInstance().getLosses(gym8)==null||GymManager.getInstance().getLosses(gym8)==0){
					GymManager.getInstance().addFakeLoss(gym8);
					p.sendMessage(Text.of(TextColors.GOLD,"8: ",gym8, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym8)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym8)/GymManager.getInstance().getLosses(gym8)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"8: ",gym8, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym8)," Losses: ",GymManager.getInstance().getLosses(gym8),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym8)/GymManager.getInstance().getLosses(gym8)));
				if(GymManager.getInstance().getLosses(gym9)==null||GymManager.getInstance().getLosses(gym9)==0){
					GymManager.getInstance().addFakeLoss(gym9);
					p.sendMessage(Text.of(TextColors.GOLD,"9: ",gym9, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym9)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym9)/GymManager.getInstance().getLosses(gym9)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"9: ",gym9, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym9)," Losses: ",GymManager.getInstance().getLosses(gym9),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym9)/GymManager.getInstance().getLosses(gym9)));
				GymManager.getInstance().removeFakeLoss(gym1);
				GymManager.getInstance().removeFakeLoss(gym2);
				GymManager.getInstance().removeFakeLoss(gym3);
				GymManager.getInstance().removeFakeLoss(gym4);
				GymManager.getInstance().removeFakeLoss(gym5);
				GymManager.getInstance().removeFakeLoss(gym6);
				GymManager.getInstance().removeFakeLoss(gym7);
				GymManager.getInstance().removeFakeLoss(gym8);
				GymManager.getInstance().removeFakeLoss(gym9);
				return CommandResult.successCount(1);
			}
			if(gym8!=null){
				if(GymManager.getInstance().getLosses(gym1)==null||GymManager.getInstance().getLosses(gym1)==0){
					GymManager.getInstance().addFakeLoss(gym1);
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",gym1, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym1)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym1)/GymManager.getInstance().getLosses(gym1)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",gym1, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym1)," Losses: ",GymManager.getInstance().getLosses(gym1),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym1)/GymManager.getInstance().getLosses(gym1)));
				if(GymManager.getInstance().getLosses(gym2)==null||GymManager.getInstance().getLosses(gym2)==0){
					GymManager.getInstance().addFakeLoss(gym2);
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",gym2, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym2)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym2)/GymManager.getInstance().getLosses(gym2)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",gym2, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym2)," Losses: ",GymManager.getInstance().getLosses(gym2),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym2)/GymManager.getInstance().getLosses(gym2)));
				if(GymManager.getInstance().getLosses(gym3)==null||GymManager.getInstance().getLosses(gym3)==0){
					GymManager.getInstance().addFakeLoss(gym3);
					p.sendMessage(Text.of(TextColors.GOLD,"3: ",gym3, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym3)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym3)/GymManager.getInstance().getLosses(gym3)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"3: ",gym3, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym3)," Losses: ",GymManager.getInstance().getLosses(gym3),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym3)/GymManager.getInstance().getLosses(gym3)));
				if(GymManager.getInstance().getLosses(gym4)==null||GymManager.getInstance().getLosses(gym4)==0){
					GymManager.getInstance().addFakeLoss(gym4);
					p.sendMessage(Text.of(TextColors.GOLD,"4: ",gym4, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym4)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym4)/GymManager.getInstance().getLosses(gym4)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"4: ",gym4, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym4)," Losses: ",GymManager.getInstance().getLosses(gym4),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym4)/GymManager.getInstance().getLosses(gym4)));
				if(GymManager.getInstance().getLosses(gym5)==null||GymManager.getInstance().getLosses(gym5)==0){
					GymManager.getInstance().addFakeLoss(gym5);
					p.sendMessage(Text.of(TextColors.GOLD,"5: ",gym5, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym5)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym5)/GymManager.getInstance().getLosses(gym5)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"5: ",gym5, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym5)," Losses: ",GymManager.getInstance().getLosses(gym5),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym5)/GymManager.getInstance().getLosses(gym5)));
				if(GymManager.getInstance().getLosses(gym6)==null||GymManager.getInstance().getLosses(gym6)==0){
					GymManager.getInstance().addFakeLoss(gym6);
					p.sendMessage(Text.of(TextColors.GOLD,"6: ",gym6, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym6)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym6)/GymManager.getInstance().getLosses(gym6)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"6: ",gym6, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym6)," Losses: ",GymManager.getInstance().getLosses(gym6),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym6)/GymManager.getInstance().getLosses(gym6)));
				if(GymManager.getInstance().getLosses(gym7)==null||GymManager.getInstance().getLosses(gym7)==0){
					GymManager.getInstance().addFakeLoss(gym7);
					p.sendMessage(Text.of(TextColors.GOLD,"7: ",gym7, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym7)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym7)/GymManager.getInstance().getLosses(gym7)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"7: ",gym7, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym7)," Losses: ",GymManager.getInstance().getLosses(gym7),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym7)/GymManager.getInstance().getLosses(gym7)));
				if(GymManager.getInstance().getLosses(gym8)==null||GymManager.getInstance().getLosses(gym8)==0){
					GymManager.getInstance().addFakeLoss(gym8);
					p.sendMessage(Text.of(TextColors.GOLD,"8: ",gym8, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym8)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym8)/GymManager.getInstance().getLosses(gym8)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"8: ",gym8, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym8)," Losses: ",GymManager.getInstance().getLosses(gym8),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym8)/GymManager.getInstance().getLosses(gym8)));
				GymManager.getInstance().removeFakeLoss(gym1);
				GymManager.getInstance().removeFakeLoss(gym2);
				GymManager.getInstance().removeFakeLoss(gym3);
				GymManager.getInstance().removeFakeLoss(gym4);
				GymManager.getInstance().removeFakeLoss(gym5);
				GymManager.getInstance().removeFakeLoss(gym6);
				GymManager.getInstance().removeFakeLoss(gym7);
				GymManager.getInstance().removeFakeLoss(gym8);
				return CommandResult.successCount(2);
			}
			if(gym7!=null){
				if(GymManager.getInstance().getLosses(gym1)==null||GymManager.getInstance().getLosses(gym1)==0){
					GymManager.getInstance().addFakeLoss(gym1);
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",gym1, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym1)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym1)/GymManager.getInstance().getLosses(gym1)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",gym1, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym1)," Losses: ",GymManager.getInstance().getLosses(gym1),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym1)/GymManager.getInstance().getLosses(gym1)));
				if(GymManager.getInstance().getLosses(gym2)==null||GymManager.getInstance().getLosses(gym2)==0){
					GymManager.getInstance().addFakeLoss(gym2);
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",gym2, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym2)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym2)/GymManager.getInstance().getLosses(gym2)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",gym2, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym2)," Losses: ",GymManager.getInstance().getLosses(gym2),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym2)/GymManager.getInstance().getLosses(gym2)));
				if(GymManager.getInstance().getLosses(gym3)==null||GymManager.getInstance().getLosses(gym3)==0){
					GymManager.getInstance().addFakeLoss(gym3);
					p.sendMessage(Text.of(TextColors.GOLD,"3: ",gym3, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym3)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym3)/GymManager.getInstance().getLosses(gym3)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"3: ",gym3, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym3)," Losses: ",GymManager.getInstance().getLosses(gym3),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym3)/GymManager.getInstance().getLosses(gym3)));
				if(GymManager.getInstance().getLosses(gym4)==null||GymManager.getInstance().getLosses(gym4)==0){
					GymManager.getInstance().addFakeLoss(gym4);
					p.sendMessage(Text.of(TextColors.GOLD,"4: ",gym4, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym4)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym4)/GymManager.getInstance().getLosses(gym4)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"4: ",gym4, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym4)," Losses: ",GymManager.getInstance().getLosses(gym4),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym4)/GymManager.getInstance().getLosses(gym4)));
				if(GymManager.getInstance().getLosses(gym5)==null||GymManager.getInstance().getLosses(gym5)==0){
					GymManager.getInstance().addFakeLoss(gym5);
					p.sendMessage(Text.of(TextColors.GOLD,"5: ",gym5, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym5)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym5)/GymManager.getInstance().getLosses(gym5)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"5: ",gym5, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym5)," Losses: ",GymManager.getInstance().getLosses(gym5),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym5)/GymManager.getInstance().getLosses(gym5)));
				if(GymManager.getInstance().getLosses(gym6)==null||GymManager.getInstance().getLosses(gym6)==0){
					GymManager.getInstance().addFakeLoss(gym6);
					p.sendMessage(Text.of(TextColors.GOLD,"6: ",gym6, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym6)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym6)/GymManager.getInstance().getLosses(gym6)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"6: ",gym6, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym6)," Losses: ",GymManager.getInstance().getLosses(gym6),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym6)/GymManager.getInstance().getLosses(gym6)));
				if(GymManager.getInstance().getLosses(gym7)==null||GymManager.getInstance().getLosses(gym7)==0){
					GymManager.getInstance().addFakeLoss(gym7);
					p.sendMessage(Text.of(TextColors.GOLD,"7: ",gym7, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym7)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym7)/GymManager.getInstance().getLosses(gym7)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"7: ",gym7, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym7)," Losses: ",GymManager.getInstance().getLosses(gym7),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym7)/GymManager.getInstance().getLosses(gym7)));
				GymManager.getInstance().removeFakeLoss(gym1);
				GymManager.getInstance().removeFakeLoss(gym2);
				GymManager.getInstance().removeFakeLoss(gym3);
				GymManager.getInstance().removeFakeLoss(gym4);
				GymManager.getInstance().removeFakeLoss(gym5);
				GymManager.getInstance().removeFakeLoss(gym6);
				GymManager.getInstance().removeFakeLoss(gym7);
				return CommandResult.successCount(3);
			}
			if(gym6!=null){
				if(GymManager.getInstance().getLosses(gym1)==null||GymManager.getInstance().getLosses(gym1)==0){
					GymManager.getInstance().addFakeLoss(gym1);
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",gym1, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym1)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym1)/GymManager.getInstance().getLosses(gym1)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",gym1, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym1)," Losses: ",GymManager.getInstance().getLosses(gym1),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym1)/GymManager.getInstance().getLosses(gym1)));
				if(GymManager.getInstance().getLosses(gym2)==null||GymManager.getInstance().getLosses(gym2)==0){
					GymManager.getInstance().addFakeLoss(gym2);
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",gym2, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym2)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym2)/GymManager.getInstance().getLosses(gym2)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",gym2, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym2)," Losses: ",GymManager.getInstance().getLosses(gym2),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym2)/GymManager.getInstance().getLosses(gym2)));
				if(GymManager.getInstance().getLosses(gym3)==null||GymManager.getInstance().getLosses(gym3)==0){
					GymManager.getInstance().addFakeLoss(gym3);
					p.sendMessage(Text.of(TextColors.GOLD,"3: ",gym3, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym3)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym3)/GymManager.getInstance().getLosses(gym3)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"3: ",gym3, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym3)," Losses: ",GymManager.getInstance().getLosses(gym3),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym3)/GymManager.getInstance().getLosses(gym3)));
				if(GymManager.getInstance().getLosses(gym4)==null||GymManager.getInstance().getLosses(gym4)==0){
					GymManager.getInstance().addFakeLoss(gym4);
					p.sendMessage(Text.of(TextColors.GOLD,"4: ",gym4, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym4)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym4)/GymManager.getInstance().getLosses(gym4)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"4: ",gym4, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym4)," Losses: ",GymManager.getInstance().getLosses(gym4),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym4)/GymManager.getInstance().getLosses(gym4)));
				if(GymManager.getInstance().getLosses(gym5)==null||GymManager.getInstance().getLosses(gym5)==0){
					GymManager.getInstance().addFakeLoss(gym5);
					p.sendMessage(Text.of(TextColors.GOLD,"5: ",gym5, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym5)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym5)/GymManager.getInstance().getLosses(gym5)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"5: ",gym5, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym5)," Losses: ",GymManager.getInstance().getLosses(gym5),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym5)/GymManager.getInstance().getLosses(gym5)));
				if(GymManager.getInstance().getLosses(gym6)==null||GymManager.getInstance().getLosses(gym6)==0){
					GymManager.getInstance().addFakeLoss(gym6);
					p.sendMessage(Text.of(TextColors.GOLD,"6: ",gym6, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym6)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym6)/GymManager.getInstance().getLosses(gym6)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"6: ",gym6, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym6)," Losses: ",GymManager.getInstance().getLosses(gym6),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym6)/GymManager.getInstance().getLosses(gym6)));
				GymManager.getInstance().removeFakeLoss(gym1);
				GymManager.getInstance().removeFakeLoss(gym2);
				GymManager.getInstance().removeFakeLoss(gym3);
				GymManager.getInstance().removeFakeLoss(gym4);
				GymManager.getInstance().removeFakeLoss(gym5);
				GymManager.getInstance().removeFakeLoss(gym6);
				return CommandResult.successCount(4);
			}
			if(gym5!=null){
				if(GymManager.getInstance().getLosses(gym1)==null||GymManager.getInstance().getLosses(gym1)==0){
					GymManager.getInstance().addFakeLoss(gym1);
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",gym1, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym1)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym1)/GymManager.getInstance().getLosses(gym1)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",gym1, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym1)," Losses: ",GymManager.getInstance().getLosses(gym1),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym1)/GymManager.getInstance().getLosses(gym1)));
				if(GymManager.getInstance().getLosses(gym2)==null||GymManager.getInstance().getLosses(gym2)==0){
					GymManager.getInstance().addFakeLoss(gym2);
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",gym2, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym2)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym2)/GymManager.getInstance().getLosses(gym2)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",gym2, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym2)," Losses: ",GymManager.getInstance().getLosses(gym2),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym2)/GymManager.getInstance().getLosses(gym2)));
				if(GymManager.getInstance().getLosses(gym3)==null||GymManager.getInstance().getLosses(gym3)==0){
					GymManager.getInstance().addFakeLoss(gym3);
					p.sendMessage(Text.of(TextColors.GOLD,"3: ",gym3, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym3)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym3)/GymManager.getInstance().getLosses(gym3)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"3: ",gym3, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym3)," Losses: ",GymManager.getInstance().getLosses(gym3),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym3)/GymManager.getInstance().getLosses(gym3)));
				if(GymManager.getInstance().getLosses(gym4)==null||GymManager.getInstance().getLosses(gym4)==0){
					GymManager.getInstance().addFakeLoss(gym4);
					p.sendMessage(Text.of(TextColors.GOLD,"4: ",gym4, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym4)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym4)/GymManager.getInstance().getLosses(gym4)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"4: ",gym4, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym4)," Losses: ",GymManager.getInstance().getLosses(gym4),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym4)/GymManager.getInstance().getLosses(gym4)));
				if(GymManager.getInstance().getLosses(gym5)==null||GymManager.getInstance().getLosses(gym5)==0){
					GymManager.getInstance().addFakeLoss(gym5);
					p.sendMessage(Text.of(TextColors.GOLD,"5: ",gym5, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym5)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym5)/GymManager.getInstance().getLosses(gym5)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"5: ",gym5, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym5)," Losses: ",GymManager.getInstance().getLosses(gym5),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym5)/GymManager.getInstance().getLosses(gym5)));
				GymManager.getInstance().removeFakeLoss(gym1);
				GymManager.getInstance().removeFakeLoss(gym2);
				GymManager.getInstance().removeFakeLoss(gym3);
				GymManager.getInstance().removeFakeLoss(gym4);
				GymManager.getInstance().removeFakeLoss(gym5);
				return CommandResult.successCount(5);
			}
			if(gym4!=null){
				if(GymManager.getInstance().getLosses(gym1)==null||GymManager.getInstance().getLosses(gym1)==0){
					GymManager.getInstance().addFakeLoss(gym1);
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",gym1, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym1)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym1)/GymManager.getInstance().getLosses(gym1)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",gym1, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym1)," Losses: ",GymManager.getInstance().getLosses(gym1),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym1)/GymManager.getInstance().getLosses(gym1)));
				if(GymManager.getInstance().getLosses(gym2)==null||GymManager.getInstance().getLosses(gym2)==0){
					GymManager.getInstance().addFakeLoss(gym2);
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",gym2, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym2)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym2)/GymManager.getInstance().getLosses(gym2)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",gym2, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym2)," Losses: ",GymManager.getInstance().getLosses(gym2),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym2)/GymManager.getInstance().getLosses(gym2)));
				if(GymManager.getInstance().getLosses(gym3)==null||GymManager.getInstance().getLosses(gym3)==0){
					GymManager.getInstance().addFakeLoss(gym3);
					p.sendMessage(Text.of(TextColors.GOLD,"3: ",gym3, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym3)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym3)/GymManager.getInstance().getLosses(gym3)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"3: ",gym3, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym3)," Losses: ",GymManager.getInstance().getLosses(gym3),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym3)/GymManager.getInstance().getLosses(gym3)));
				if(GymManager.getInstance().getLosses(gym4)==null||GymManager.getInstance().getLosses(gym4)==0){
					GymManager.getInstance().addFakeLoss(gym4);
					p.sendMessage(Text.of(TextColors.GOLD,"4: ",gym4, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym4)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym4)/GymManager.getInstance().getLosses(gym4)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"4: ",gym4, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym4)," Losses: ",GymManager.getInstance().getLosses(gym4),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym4)/GymManager.getInstance().getLosses(gym4)));
				GymManager.getInstance().removeFakeLoss(gym1);
				GymManager.getInstance().removeFakeLoss(gym2);
				GymManager.getInstance().removeFakeLoss(gym3);
				GymManager.getInstance().removeFakeLoss(gym4);
				return CommandResult.successCount(6);
			}
			if(gym3!=null){
				if(GymManager.getInstance().getLosses(gym1)==null||GymManager.getInstance().getLosses(gym1)==0){
					GymManager.getInstance().addFakeLoss(gym1);
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",gym1, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym1)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym1)/GymManager.getInstance().getLosses(gym1)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",gym1, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym1)," Losses: ",GymManager.getInstance().getLosses(gym1),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym1)/GymManager.getInstance().getLosses(gym1)));
				if(GymManager.getInstance().getLosses(gym2)==null||GymManager.getInstance().getLosses(gym2)==0){
					GymManager.getInstance().addFakeLoss(gym2);
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",gym2, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym2)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym2)/GymManager.getInstance().getLosses(gym2)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",gym2, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym2)," Losses: ",GymManager.getInstance().getLosses(gym2),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym2)/GymManager.getInstance().getLosses(gym2)));
				if(GymManager.getInstance().getLosses(gym3)==null||GymManager.getInstance().getLosses(gym3)==0){
					GymManager.getInstance().addFakeLoss(gym3);
					p.sendMessage(Text.of(TextColors.GOLD,"3: ",gym3, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym3)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym3)/GymManager.getInstance().getLosses(gym3)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"3: ",gym3, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym3)," Losses: ",GymManager.getInstance().getLosses(gym3),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym3)/GymManager.getInstance().getLosses(gym3)));
				GymManager.getInstance().removeFakeLoss(gym1);
				GymManager.getInstance().removeFakeLoss(gym2);
				GymManager.getInstance().removeFakeLoss(gym3);
				return CommandResult.successCount(7);
			}
			if(gym2!=null){
				if(GymManager.getInstance().getLosses(gym1)==null||GymManager.getInstance().getLosses(gym1)==0){
					GymManager.getInstance().addFakeLoss(gym1);
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",gym1, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym1)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym1)/GymManager.getInstance().getLosses(gym1)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",gym1, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym1)," Losses: ",GymManager.getInstance().getLosses(gym1),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym1)/GymManager.getInstance().getLosses(gym1)));
				if(GymManager.getInstance().getLosses(gym2)==null||GymManager.getInstance().getLosses(gym2)==0){
					GymManager.getInstance().addFakeLoss(gym2);
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",gym2, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym2)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym2)/GymManager.getInstance().getLosses(gym2)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"2: ",gym2, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym2)," Losses: ",GymManager.getInstance().getLosses(gym2),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym2)/GymManager.getInstance().getLosses(gym2)));
				GymManager.getInstance().removeFakeLoss(gym1);
				GymManager.getInstance().removeFakeLoss(gym2);
				return CommandResult.successCount(8);
			}
			if(gym1!=null){
				if(GymManager.getInstance().getLosses(gym1)==null||GymManager.getInstance().getLosses(gym1)==0){
					GymManager.getInstance().addFakeLoss(gym1);
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",gym1, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym1)," Losses: 0",TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym1)/GymManager.getInstance().getLosses(gym1)));
				}else
					p.sendMessage(Text.of(TextColors.GOLD,"1: ",gym1, TextColors.RED," Wins: ",GymManager.getInstance().getWins(gym1)," Losses: ",GymManager.getInstance().getLosses(gym1),TextColors.DARK_GREEN," W/L Ratio: ",GymManager.getInstance().getWins(gym1)/GymManager.getInstance().getLosses(gym1)));
				GymManager.getInstance().removeFakeLoss(gym1);
				return CommandResult.successCount(9);
			}
			p.sendMessage(Text.of(TextColors.GOLD,"There Are No Players With Wins Or Losses!"));
			
		}
		return CommandResult.success();
	}
}
