package com.cameronhetzler.paypal.spectypes;

import java.util.List;

import com.google.gson.reflect.TypeToken;
import com.paypal.api.products.Product;

public class ProductType extends BaseType<Product> {

	public static enum Category {

		AC_REFRIGERATION_REPAIR("AC_REFRIGERATION_REPAIR"), ACADEMIC_SOFTWARE("ACADEMIC_SOFTWARE"),
		ACCESSORIES("ACCESSORIES"), ACCOUNTING("ACCOUNTING"), ADULT("ADULT"), ADVERTISING("ADVERTISING"),
		AFFILIATED_AUTO_RENTAL("AFFILIATED_AUTO_RENTAL"), AGENCIES("AGENCIES"), AGGREGATORS("AGGREGATORS"),
		AGRICULTURAL_COOPERATIVE_FOR_MAIL_ORDER("AGRICULTURAL_COOPERATIVE_FOR_MAIL_ORDER"),
		AIR_CARRIERS_AIRLINES("AIR_CARRIERS_AIRLINES"), AIRLINES("AIRLINES"),
		AIRPORTS_FLYING_FIELDS("AIRPORTS_FLYING_FIELDS"), ALCOHOLIC_BEVERAGES("ALCOHOLIC_BEVERAGES"),
		AMUSEMENT_PARKS_CARNIVALS("AMUSEMENT_PARKS_CARNIVALS"), ANIMATION("ANIMATION"), ANTIQUES("ANTIQUES"),
		APPLIANCES("APPLIANCES"), AQUARIAMS_SEAQUARIUMS_DOLPHINARIUMS("AQUARIAMS_SEAQUARIUMS_DOLPHINARIUMS"),
		ARCHITECTURAL_ENGINEERING_AND_SURVEYING_SERVICES("ARCHITECTURAL_ENGINEERING_AND_SURVEYING_SERVICES"),
		ART_AND_CRAFT_SUPPLIES("ART_AND_CRAFT_SUPPLIES"), ART_DEALERS_AND_GALLERIES("ART_DEALERS_AND_GALLERIES"),
		ARTIFACTS_GRAVE_RELATED_AND_NATIVE_AMERICAN_CRAFTS("ARTIFACTS_GRAVE_RELATED_AND_NATIVE_AMERICAN_CRAFTS"),
		ARTS_AND_CRAFTS("ARTS_AND_CRAFTS"), ARTS_CRAFTS_AND_COLLECTIBLES("ARTS_CRAFTS_AND_COLLECTIBLES"),
		AUDIO_BOOKS("AUDIO_BOOKS"), AUTO_ASSOCIATIONS_CLUBS("AUTO_ASSOCIATIONS_CLUBS"),
		AUTO_DEALER_USED_ONLY("AUTO_DEALER_USED_ONLY"), AUTO_RENTALS("AUTO_RENTALS"), AUTO_SERVICE("AUTO_SERVICE"),
		AUTOMATED_FUEL_DISPENSERS("AUTOMATED_FUEL_DISPENSERS"), AUTOMOBILE_ASSOCIATIONS("AUTOMOBILE_ASSOCIATIONS"),
		AUTOMOTIVE("AUTOMOTIVE"), AUTOMOTIVE_REPAIR_SHOPS_NON_DEALER("AUTOMOTIVE_REPAIR_SHOPS_NON_DEALER"),
		AUTOMOTIVE_TOP_AND_BODY_SHOPS("AUTOMOTIVE_TOP_AND_BODY_SHOPS"), AVIATION("AVIATION"),
		BABIES_CLOTHING_AND_SUPPLIES("BABIES_CLOTHING_AND_SUPPLIES"), BABY("BABY"),
		BANDS_ORCHESTRAS_ENTERTAINERS("BANDS_ORCHESTRAS_ENTERTAINERS"), BARBIES("BARBIES"),
		BATH_AND_BODY("BATH_AND_BODY"), BATTERIES("BATTERIES"), BEAN_BABIES("BEAN_BABIES"), BEAUTY("BEAUTY"),
		BEAUTY_AND_FRAGRANCES("BEAUTY_AND_FRAGRANCES"), BED_AND_BATH("BED_AND_BATH"),
		BICYCLE_SHOPS_SALES_AND_SERVICE("BICYCLE_SHOPS_SALES_AND_SERVICE"),
		BICYCLES_AND_ACCESSORIES("BICYCLES_AND_ACCESSORIES"),
		BILLIARD_POOL_ESTABLISHMENTS("BILLIARD_POOL_ESTABLISHMENTS"), BOAT_DEALERS("BOAT_DEALERS"),
		BOAT_RENTALS_AND_LEASING("BOAT_RENTALS_AND_LEASING"),
		BOATING_SAILING_AND_ACCESSORIES("BOATING_SAILING_AND_ACCESSORIES"), BOOKS("BOOKS"),
		BOOKS_AND_MAGAZINES("BOOKS_AND_MAGAZINES"), BOOKS_MANUSCRIPTS("BOOKS_MANUSCRIPTS"),
		BOOKS_PERIODICALS_AND_NEWSPAPERS("BOOKS_PERIODICALS_AND_NEWSPAPERS"), BOWLING_ALLEYS("BOWLING_ALLEYS"),
		BULLETIN_BOARD("BULLETIN_BOARD"), BUS_LINE("BUS_LINE"),
		BUS_LINES_CHARTERS_TOUR_BUSES("BUS_LINES_CHARTERS_TOUR_BUSES"), BUSINESS("BUSINESS"),
		BUSINESS_AND_SECRETARIAL_SCHOOLS("BUSINESS_AND_SECRETARIAL_SCHOOLS"),
		BUYING_AND_SHOPPING_SERVICES_AND_CLUBS("BUYING_AND_SHOPPING_SERVICES_AND_CLUBS"),
		CABLE_SATELLITE_AND_OTHER_PAY_TELEVISION_AND_RADIO_SERVICES(
				"CABLE_SATELLITE_AND_OTHER_PAY_TELEVISION_AND_RADIO_SERVICES"),
		CABLE_SATELLITE_AND_OTHER_PAY_TV_AND_RADIO("CABLE_SATELLITE_AND_OTHER_PAY_TV_AND_RADIO"),
		CAMERA_AND_PHOTOGRAPHIC_SUPPLIES("CAMERA_AND_PHOTOGRAPHIC_SUPPLIES"), CAMERAS("CAMERAS"),
		CAMERAS_AND_PHOTOGRAPHY("CAMERAS_AND_PHOTOGRAPHY"),
		CAMPER_RECREATIONAL_AND_UTILITY_TRAILER_DEALERS("CAMPER_RECREATIONAL_AND_UTILITY_TRAILER_DEALERS"),
		CAMPING_AND_OUTDOORS("CAMPING_AND_OUTDOORS"), CAMPING_AND_SURVIVAL("CAMPING_AND_SURVIVAL"),
		CAR_AND_TRUCK_DEALERS("CAR_AND_TRUCK_DEALERS"),
		CAR_AND_TRUCK_DEALERS_USED_ONLY("CAR_AND_TRUCK_DEALERS_USED_ONLY"),
		CAR_AUDIO_AND_ELECTRONICS("CAR_AUDIO_AND_ELECTRONICS"), CAR_RENTAL_AGENCY("CAR_RENTAL_AGENCY"),
		CATALOG_MERCHANT("CATALOG_MERCHANT"), CATALOG_RETAIL_MERCHANT("CATALOG_RETAIL_MERCHANT"),
		CATERING_SERVICES("CATERING_SERVICES"), CHARITY("CHARITY"), CHECK_CASHIER("CHECK_CASHIER"),
		CHILD_CARE_SERVICES("CHILD_CARE_SERVICES"), CHILDREN_BOOKS("CHILDREN_BOOKS"),
		CHIROPODISTS_PODIATRISTS("CHIROPODISTS_PODIATRISTS"), CHIROPRACTORS("CHIROPRACTORS"),
		CIGAR_STORES_AND_STANDS("CIGAR_STORES_AND_STANDS"),
		CIVIC_SOCIAL_FRATERNAL_ASSOCIATIONS("CIVIC_SOCIAL_FRATERNAL_ASSOCIATIONS"),
		CIVIL_SOCIAL_FRAT_ASSOCIATIONS("CIVIL_SOCIAL_FRAT_ASSOCIATIONS"), CLOTHING("CLOTHING"),
		CLOTHING_ACCESSORIES_AND_SHOES("CLOTHING_ACCESSORIES_AND_SHOES"), CLOTHING_RENTAL("CLOTHING_RENTAL"),
		COFFEE_AND_TEA("COFFEE_AND_TEA"), COIN_OPERATED_BANKS_AND_CASINOS("COIN_OPERATED_BANKS_AND_CASINOS"),
		COLLECTIBLES("COLLECTIBLES"), COLLECTION_AGENCY("COLLECTION_AGENCY"),
		COLLEGES_AND_UNIVERSITIES("COLLEGES_AND_UNIVERSITIES"), COMMERCIAL_EQUIPMENT("COMMERCIAL_EQUIPMENT"),
		COMMERCIAL_FOOTWEAR("COMMERCIAL_FOOTWEAR"), COMMERCIAL_PHOTOGRAPHY("COMMERCIAL_PHOTOGRAPHY"),
		COMMERCIAL_PHOTOGRAPHY_ART_AND_GRAPHICS("COMMERCIAL_PHOTOGRAPHY_ART_AND_GRAPHICS"),
		COMMERCIAL_SPORTS_PROFESSIONA("COMMERCIAL_SPORTS_PROFESSIONA"),
		COMMODITIES_AND_FUTURES_EXCHANGE("COMMODITIES_AND_FUTURES_EXCHANGE"),
		COMPUTER_AND_DATA_PROCESSING_SERVICES("COMPUTER_AND_DATA_PROCESSING_SERVICES"),
		COMPUTER_HARDWARE_AND_SOFTWARE("COMPUTER_HARDWARE_AND_SOFTWARE"),
		COMPUTER_MAINTENANCE_REPAIR_AND_SERVICES_NOT_ELSEWHERE_CLAS(
				"COMPUTER_MAINTENANCE_REPAIR_AND_SERVICES_NOT_ELSEWHERE_CLAS"),
		CONSTRUCTION("CONSTRUCTION"),
		CONSTRUCTION_MATERIALS_NOT_ELSEWHERE_CLASSIFIED("CONSTRUCTION_MATERIALS_NOT_ELSEWHERE_CLASSIFIED"),
		CONSULTING_SERVICES("CONSULTING_SERVICES"),
		CONSUMER_CREDIT_REPORTING_AGENCIES("CONSUMER_CREDIT_REPORTING_AGENCIES"),
		CONVALESCENT_HOMES("CONVALESCENT_HOMES"), COSMETIC_STORES("COSMETIC_STORES"),
		COUNSELING_SERVICES_DEBT_MARRIAGE_PERSONAL("COUNSELING_SERVICES_DEBT_MARRIAGE_PERSONAL"),
		COUNTERFEIT_CURRENCY_AND_STAMPS("COUNTERFEIT_CURRENCY_AND_STAMPS"), COUNTERFEIT_ITEMS("COUNTERFEIT_ITEMS"),
		COUNTRY_CLUBS("COUNTRY_CLUBS"), COURIER_SERVICES("COURIER_SERVICES"),
		COURIER_SERVICES_AIR_AND_GROUND_AND_FREIGHT_FORWARDERS(
				"COURIER_SERVICES_AIR_AND_GROUND_AND_FREIGHT_FORWARDERS"),
		COURT_COSTS_ALIMNY_CHILD_SUPT("COURT_COSTS_ALIMNY_CHILD_SUPT"),
		COURT_COSTS_INCLUDING_ALIMONY_AND_CHILD_SUPPORT_COURTS_OF_LAW(
				"COURT_COSTS_INCLUDING_ALIMONY_AND_CHILD_SUPPORT_COURTS_OF_LAW"),
		CREDIT_CARDS("CREDIT_CARDS"), CREDIT_UNION("CREDIT_UNION"), CULTURE_AND_RELIGION("CULTURE_AND_RELIGION"),
		DAIRY_PRODUCTS_STORES("DAIRY_PRODUCTS_STORES"),
		DANCE_HALLS_STUDIOS_AND_SCHOOLS("DANCE_HALLS_STUDIOS_AND_SCHOOLS"), DECORATIVE("DECORATIVE"), DENTAL("DENTAL"),
		DENTISTS_AND_ORTHODONTISTS("DENTISTS_AND_ORTHODONTISTS"), DEPARTMENT_STORES("DEPARTMENT_STORES"),
		DESKTOP_PCS("DESKTOP_PCS"), DEVICES("DEVICES"), DIECAST_TOYS_VEHICLES("DIECAST_TOYS_VEHICLES"),
		DIGITAL_GAMES("DIGITAL_GAMES"), DIGITAL_MEDIA_BOOKS_MOVIES_MUSIC("DIGITAL_MEDIA_BOOKS_MOVIES_MUSIC"),
		DIRECT_MARKETING("DIRECT_MARKETING"), DIRECT_MARKETING_CATALOG_MERCHANT("DIRECT_MARKETING_CATALOG_MERCHANT"),
		DIRECT_MARKETING_INBOUND_TELE("DIRECT_MARKETING_INBOUND_TELE"),
		DIRECT_MARKETING_OUTBOUND_TELE("DIRECT_MARKETING_OUTBOUND_TELE"),
		DIRECT_MARKETING_SUBSCRIPTION("DIRECT_MARKETING_SUBSCRIPTION"), DISCOUNT_STORES("DISCOUNT_STORES"),
		DOOR_TO_DOOR_SALES("DOOR_TO_DOOR_SALES"),
		DRAPERY_WINDOW_COVERING_AND_UPHOLSTERY("DRAPERY_WINDOW_COVERING_AND_UPHOLSTERY"),
		DRINKING_PLACES("DRINKING_PLACES"), DRUGSTORE("DRUGSTORE"), DURABLE_GOODS("DURABLE_GOODS"),
		ECOMMERCE_DEVELOPMENT("ECOMMERCE_DEVELOPMENT"), ECOMMERCE_SERVICES("ECOMMERCE_SERVICES"),
		EDUCATIONAL_AND_TEXTBOOKS("EDUCATIONAL_AND_TEXTBOOKS"), ELECTRIC_RAZOR_STORES("ELECTRIC_RAZOR_STORES"),
		ELECTRICAL_AND_SMALL_APPLIANCE_REPAIR("ELECTRICAL_AND_SMALL_APPLIANCE_REPAIR"),
		ELECTRICAL_CONTRACTORS("ELECTRICAL_CONTRACTORS"),
		ELECTRICAL_PARTS_AND_EQUIPMENT("ELECTRICAL_PARTS_AND_EQUIPMENT"), ELECTRONIC_CASH("ELECTRONIC_CASH"),
		ELEMENTARY_AND_SECONDARY_SCHOOLS("ELEMENTARY_AND_SECONDARY_SCHOOLS"), EMPLOYMENT("EMPLOYMENT"),
		ENTERTAINERS("ENTERTAINERS"), ENTERTAINMENT_AND_MEDIA("ENTERTAINMENT_AND_MEDIA"),
		EQUIP_TOOL_FURNITURE_AND_APPLIANCE_RENTAL_AND_LEASING("EQUIP_TOOL_FURNITURE_AND_APPLIANCE_RENTAL_AND_LEASING"),
		ESCROW("ESCROW"), EVENT_AND_WEDDING_PLANNING("EVENT_AND_WEDDING_PLANNING"),
		EXERCISE_AND_FITNESS("EXERCISE_AND_FITNESS"), EXERCISE_EQUIPMENT("EXERCISE_EQUIPMENT"),
		EXTERMINATING_AND_DISINFECTING_SERVICES("EXTERMINATING_AND_DISINFECTING_SERVICES"),
		FABRICS_AND_SEWING("FABRICS_AND_SEWING"), FAMILY_CLOTHING_STORES("FAMILY_CLOTHING_STORES"),
		FASHION_JEWELRY("FASHION_JEWELRY"), FAST_FOOD_RESTAURANTS("FAST_FOOD_RESTAURANTS"),
		FICTION_AND_NONFICTION("FICTION_AND_NONFICTION"), FINANCE_COMPANY("FINANCE_COMPANY"),
		FINANCIAL_AND_INVESTMENT_ADVICE("FINANCIAL_AND_INVESTMENT_ADVICE"),
		FINANCIAL_INSTITUTIONS_MERCHANDISE_AND_SERVICES("FINANCIAL_INSTITUTIONS_MERCHANDISE_AND_SERVICES"),
		FIREARM_ACCESSORIES("FIREARM_ACCESSORIES"), FIREARMS_WEAPONS_AND_KNIVES("FIREARMS_WEAPONS_AND_KNIVES"),
		FIREPLACE_AND_FIREPLACE_SCREENS("FIREPLACE_AND_FIREPLACE_SCREENS"), FIREWORKS("FIREWORKS"), FISHING("FISHING"),
		FLORISTS("FLORISTS"), FLOWERS("FLOWERS"), FOOD_DRINK_AND_NUTRITION("FOOD_DRINK_AND_NUTRITION"),
		FOOD_PRODUCTS("FOOD_PRODUCTS"), FOOD_RETAIL_AND_SERVICE("FOOD_RETAIL_AND_SERVICE"),
		FRAGRANCES_AND_PERFUMES("FRAGRANCES_AND_PERFUMES"),
		FREEZER_AND_LOCKER_MEAT_PROVISIONERS("FREEZER_AND_LOCKER_MEAT_PROVISIONERS"),
		FUEL_DEALERS_FUEL_OIL_WOOD_AND_COAL("FUEL_DEALERS_FUEL_OIL_WOOD_AND_COAL"),
		FUEL_DEALERS_NON_AUTOMOTIVE("FUEL_DEALERS_NON_AUTOMOTIVE"),
		FUNERAL_SERVICES_AND_CREMATORIES("FUNERAL_SERVICES_AND_CREMATORIES"),
		FURNISHING_AND_DECORATING("FURNISHING_AND_DECORATING"), FURNITURE("FURNITURE"),
		FURRIERS_AND_FUR_SHOPS("FURRIERS_AND_FUR_SHOPS"),
		GADGETS_AND_OTHER_ELECTRONICS("GADGETS_AND_OTHER_ELECTRONICS"), GAMBLING("GAMBLING"),
		GAME_SOFTWARE("GAME_SOFTWARE"), GAMES("GAMES"), GARDEN_SUPPLIES("GARDEN_SUPPLIES"), GENERAL("GENERAL"),
		GENERAL_CONTRACTORS("GENERAL_CONTRACTORS"), GENERAL_GOVERNMENT("GENERAL_GOVERNMENT"),
		GENERAL_SOFTWARE("GENERAL_SOFTWARE"), GENERAL_TELECOM("GENERAL_TELECOM"),
		GIFTS_AND_FLOWERS("GIFTS_AND_FLOWERS"), GLASS_PAINT_AND_WALLPAPER_STORES("GLASS_PAINT_AND_WALLPAPER_STORES"),
		GLASSWARE_CRYSTAL_STORES("GLASSWARE_CRYSTAL_STORES"), GOVERNMENT("GOVERNMENT"),
		GOVERNMENT_IDS_AND_LICENSES("GOVERNMENT_IDS_AND_LICENSES"),
		GOVERNMENT_LICENSED_ON_LINE_CASINOS_ON_LINE_GAMBLING("GOVERNMENT_LICENSED_ON_LINE_CASINOS_ON_LINE_GAMBLING"),
		GOVERNMENT_OWNED_LOTTERIES("GOVERNMENT_OWNED_LOTTERIES"), GOVERNMENT_SERVICES("GOVERNMENT_SERVICES"),
		GRAPHIC_AND_COMMERCIAL_DESIGN("GRAPHIC_AND_COMMERCIAL_DESIGN"), GREETING_CARDS("GREETING_CARDS"),
		GROCERY_STORES_AND_SUPERMARKETS("GROCERY_STORES_AND_SUPERMARKETS"), HARDWARE_AND_TOOLS("HARDWARE_AND_TOOLS"),
		HARDWARE_EQUIPMENT_AND_SUPPLIES("HARDWARE_EQUIPMENT_AND_SUPPLIES"),
		HAZARDOUS_RESTRICTED_AND_PERISHABLE_ITEMS("HAZARDOUS_RESTRICTED_AND_PERISHABLE_ITEMS"),
		HEALTH_AND_BEAUTY_SPAS("HEALTH_AND_BEAUTY_SPAS"), HEALTH_AND_NUTRITION("HEALTH_AND_NUTRITION"),
		HEALTH_AND_PERSONAL_CARE("HEALTH_AND_PERSONAL_CARE"),
		HEARING_AIDS_SALES_AND_SUPPLIES("HEARING_AIDS_SALES_AND_SUPPLIES"), HEATING_PLUMBING_AC("HEATING_PLUMBING_AC"),
		HIGH_RISK_MERCHANT("HIGH_RISK_MERCHANT"), HIRING_SERVICES("HIRING_SERVICES"),
		HOBBIES_TOYS_AND_GAMES("HOBBIES_TOYS_AND_GAMES"), HOME_AND_GARDEN("HOME_AND_GARDEN"), HOME_AUDIO("HOME_AUDIO"),
		HOME_DECOR("HOME_DECOR"), HOME_ELECTRONICS("HOME_ELECTRONICS"), HOSPITALS("HOSPITALS"),
		HOTELS_MOTELS_INNS_RESORTS("HOTELS_MOTELS_INNS_RESORTS"), HOUSEWARES("HOUSEWARES"),
		HUMAN_PARTS_AND_REMAINS("HUMAN_PARTS_AND_REMAINS"),
		HUMOROUS_GIFTS_AND_NOVELTIES("HUMOROUS_GIFTS_AND_NOVELTIES"), HUNTING("HUNTING"),
		IDS_LICENSES_AND_PASSPORTS("IDS_LICENSES_AND_PASSPORTS"),
		ILLEGAL_DRUGS_AND_PARAPHERNALIA("ILLEGAL_DRUGS_AND_PARAPHERNALIA"), INDUSTRIAL("INDUSTRIAL"),
		INDUSTRIAL_AND_MANUFACTURING_SUPPLIES("INDUSTRIAL_AND_MANUFACTURING_SUPPLIES"),
		INSURANCE_AUTO_AND_HOME("INSURANCE_AUTO_AND_HOME"), INSURANCE_DIRECT("INSURANCE_DIRECT"),
		INSURANCE_LIFE_AND_ANNUITY("INSURANCE_LIFE_AND_ANNUITY"),
		INSURANCE_SALES_UNDERWRITING("INSURANCE_SALES_UNDERWRITING"),
		INSURANCE_UNDERWRITING_PREMIUMS("INSURANCE_UNDERWRITING_PREMIUMS"),
		INTERNET_AND_NETWORK_SERVICES("INTERNET_AND_NETWORK_SERVICES"),
		INTRA_COMPANY_PURCHASES("INTRA_COMPANY_PURCHASES"), LABORATORIES_DENTAL_MEDICAL("LABORATORIES_DENTAL_MEDICAL"),
		LANDSCAPING("LANDSCAPING"), LANDSCAPING_AND_HORTICULTURAL_SERVICES("LANDSCAPING_AND_HORTICULTURAL_SERVICES"),
		LAUNDRY_CLEANING_SERVICES("LAUNDRY_CLEANING_SERVICES"), LEGAL("LEGAL"),
		LEGAL_SERVICES_AND_ATTORNEYS("LEGAL_SERVICES_AND_ATTORNEYS"), LOCAL_DELIVERY_SERVICE("LOCAL_DELIVERY_SERVICE"),
		LOCKSMITH("LOCKSMITH"), LODGING_AND_ACCOMMODATIONS("LODGING_AND_ACCOMMODATIONS"),
		LOTTERY_AND_CONTESTS("LOTTERY_AND_CONTESTS"), LUGGAGE_AND_LEATHER_GOODS("LUGGAGE_AND_LEATHER_GOODS"),
		LUMBER_AND_BUILDING_MATERIALS("LUMBER_AND_BUILDING_MATERIALS"), MAGAZINES("MAGAZINES"),
		MAINTENANCE_AND_REPAIR_SERVICES("MAINTENANCE_AND_REPAIR_SERVICES"),
		MAKEUP_AND_COSMETICS("MAKEUP_AND_COSMETICS"), MANUAL_CASH_DISBURSEMENTS("MANUAL_CASH_DISBURSEMENTS"),
		MASSAGE_PARLORS("MASSAGE_PARLORS"), MEDICAL("MEDICAL"),
		MEDICAL_AND_PHARMACEUTICAL("MEDICAL_AND_PHARMACEUTICAL"), MEDICAL_CARE("MEDICAL_CARE"),
		MEDICAL_EQUIPMENT_AND_SUPPLIES("MEDICAL_EQUIPMENT_AND_SUPPLIES"), MEDICAL_SERVICES("MEDICAL_SERVICES"),
		MEETING_PLANNERS("MEETING_PLANNERS"), MEMBERSHIP_CLUBS_AND_ORGANIZATIONS("MEMBERSHIP_CLUBS_AND_ORGANIZATIONS"),
		MEMBERSHIP_COUNTRY_CLUBS_GOLF("MEMBERSHIP_COUNTRY_CLUBS_GOLF"), MEMORABILIA("MEMORABILIA"),
		MEN_AND_BOY_CLOTHING_AND_ACCESSORY_STORES("MEN_AND_BOY_CLOTHING_AND_ACCESSORY_STORES"),
		MEN_CLOTHING("MEN_CLOTHING"), MERCHANDISE("MERCHANDISE"), METAPHYSICAL("METAPHYSICAL"), MILITARIA("MILITARIA"),
		MILITARY_AND_CIVIL_SERVICE_UNIFORMS("MILITARY_AND_CIVIL_SERVICE_UNIFORMS"),
		MISC_AUTOMOTIVE_AIRCRAFT_AND_FARM_EQUIPMENT_DEALERS("MISC._AUTOMOTIVE_AIRCRAFT_AND_FARM_EQUIPMENT_DEALERS"),
		MISC_GENERAL_MERCHANDISE("MISC._GENERAL_MERCHANDISE"),
		MISCELLANEOUS_GENERAL_SERVICES("MISCELLANEOUS_GENERAL_SERVICES"),
		MISCELLANEOUS_REPAIR_SHOPS_AND_RELATED_SERVICES("MISCELLANEOUS_REPAIR_SHOPS_AND_RELATED_SERVICES"),
		MODEL_KITS("MODEL_KITS"),
		MONEY_TRANSFER_MEMBER_FINANCIAL_INSTITUTION("MONEY_TRANSFER_MEMBER_FINANCIAL_INSTITUTION"),
		MONEY_TRANSFER_MERCHANT("MONEY_TRANSFER_MERCHANT"), MOTION_PICTURE_THEATERS("MOTION_PICTURE_THEATERS"),
		MOTOR_FREIGHT_CARRIERS_AND_TRUCKING("MOTOR_FREIGHT_CARRIERS_AND_TRUCKING"),
		MOTOR_HOME_AND_RECREATIONAL_VEHICLE_RENTAL("MOTOR_HOME_AND_RECREATIONAL_VEHICLE_RENTAL"),
		MOTOR_HOMES_DEALERS("MOTOR_HOMES_DEALERS"),
		MOTOR_VEHICLE_SUPPLIES_AND_NEW_PARTS("MOTOR_VEHICLE_SUPPLIES_AND_NEW_PARTS"),
		MOTORCYCLE_DEALERS("MOTORCYCLE_DEALERS"), MOTORCYCLES("MOTORCYCLES"), MOVIE("MOVIE"),
		MOVIE_TICKETS("MOVIE_TICKETS"), MOVING_AND_STORAGE("MOVING_AND_STORAGE"),
		MULTI_LEVEL_MARKETING("MULTI_LEVEL_MARKETING"),
		MUSIC_CDS_CASSETTES_AND_ALBUMS("MUSIC_CDS_CASSETTES_AND_ALBUMS"),
		MUSIC_STORE_INSTRUMENTS_AND_SHEET_MUSIC("MUSIC_STORE_INSTRUMENTS_AND_SHEET_MUSIC"), NETWORKING("NETWORKING"),
		NEW_AGE("NEW_AGE"), NEW_PARTS_AND_SUPPLIES_MOTOR_VEHICLE("NEW_PARTS_AND_SUPPLIES_MOTOR_VEHICLE"),
		NEWS_DEALERS_AND_NEWSTANDS("NEWS_DEALERS_AND_NEWSTANDS"), NON_DURABLE_GOODS("NON_DURABLE_GOODS"),
		NON_FICTION("NON_FICTION"), NON_PROFIT_POLITICAL_AND_RELIGION("NON_PROFIT_POLITICAL_AND_RELIGION"),
		NONPROFIT("NONPROFIT"), NOVELTIES("NOVELTIES"), OEM_SOFTWARE("OEM_SOFTWARE"),
		OFFICE_SUPPLIES_AND_EQUIPMENT("OFFICE_SUPPLIES_AND_EQUIPMENT"), ONLINE_DATING("ONLINE_DATING"),
		ONLINE_GAMING("ONLINE_GAMING"), ONLINE_GAMING_CURRENCY("ONLINE_GAMING_CURRENCY"),
		ONLINE_SERVICES("ONLINE_SERVICES"), OOUTBOUND_TELEMARKETING_MERCH("OOUTBOUND_TELEMARKETING_MERCH"),
		OPHTHALMOLOGISTS_OPTOMETRIST("OPHTHALMOLOGISTS_OPTOMETRIST"),
		OPTICIANS_AND_DISPENSING("OPTICIANS_AND_DISPENSING"),
		ORTHOPEDIC_GOODS_PROSTHETICS("ORTHOPEDIC_GOODS_PROSTHETICS"), OSTEOPATHS("OSTEOPATHS"), OTHER("OTHER"),
		PACKAGE_TOUR_OPERATORS("PACKAGE_TOUR_OPERATORS"), PAINTBALL("PAINTBALL"),
		PAINTS_VARNISHES_AND_SUPPLIES("PAINTS_VARNISHES_AND_SUPPLIES"),
		PARKING_LOTS_AND_GARAGES("PARKING_LOTS_AND_GARAGES"), PARTS_AND_ACCESSORIES("PARTS_AND_ACCESSORIES"),
		PAWN_SHOPS("PAWN_SHOPS"), PAYCHECK_LENDER_OR_CASH_ADVANCE("PAYCHECK_LENDER_OR_CASH_ADVANCE"),
		PERIPHERALS("PERIPHERALS"), PERSONALIZED_GIFTS("PERSONALIZED_GIFTS"),
		PET_SHOPS_PET_FOOD_AND_SUPPLIES("PET_SHOPS_PET_FOOD_AND_SUPPLIES"),
		PETROLEUM_AND_PETROLEUM_PRODUCTS("PETROLEUM_AND_PETROLEUM_PRODUCTS"), PETS_AND_ANIMALS("PETS_AND_ANIMALS"),
		PHOTOFINISHING_LABORATORIES_PHOTO_DEVELOPING("PHOTOFINISHING_LABORATORIES_PHOTO_DEVELOPING"),
		PHOTOGRAPHIC_STUDIOS_PORTRAITS("PHOTOGRAPHIC_STUDIOS_PORTRAITS"), PHOTOGRAPHY("PHOTOGRAPHY"),
		PHYSICAL_GOOD("PHYSICAL_GOOD"), PICTURE_VIDEO_PRODUCTION("PICTURE_VIDEO_PRODUCTION"),
		PIECE_GOODS_NOTIONS_AND_OTHER_DRY_GOODS("PIECE_GOODS_NOTIONS_AND_OTHER_DRY_GOODS"),
		PLANTS_AND_SEEDS("PLANTS_AND_SEEDS"),
		PLUMBING_AND_HEATING_EQUIPMENTS_AND_SUPPLIES("PLUMBING_AND_HEATING_EQUIPMENTS_AND_SUPPLIES"),
		POLICE_RELATED_ITEMS("POLICE_RELATED_ITEMS"), POLITICAL_ORGANIZATIONS("POLITICAL_ORGANIZATIONS"),
		POSTAL_SERVICES_GOVERNMENT_ONLY("POSTAL_SERVICES_GOVERNMENT_ONLY"), POSTERS("POSTERS"),
		PREPAID_AND_STORED_VALUE_CARDS("PREPAID_AND_STORED_VALUE_CARDS"), PRESCRIPTION_DRUGS("PRESCRIPTION_DRUGS"),
		PROMOTIONAL_ITEMS("PROMOTIONAL_ITEMS"), PUBLIC_WAREHOUSING_AND_STORAGE("PUBLIC_WAREHOUSING_AND_STORAGE"),
		PUBLISHING_AND_PRINTING("PUBLISHING_AND_PRINTING"), PUBLISHING_SERVICES("PUBLISHING_SERVICES"),
		RADAR_DECTORS("RADAR_DECTORS"), RADIO_TELEVISION_AND_STEREO_REPAIR("RADIO_TELEVISION_AND_STEREO_REPAIR"),
		REAL_ESTATE("REAL_ESTATE"), REAL_ESTATE_AGENT("REAL_ESTATE_AGENT"),
		REAL_ESTATE_AGENTS_AND_MANAGERS_RENTALS("REAL_ESTATE_AGENTS_AND_MANAGERS_RENTALS"),
		RELIGION_AND_SPIRITUALITY_FOR_PROFIT("RELIGION_AND_SPIRITUALITY_FOR_PROFIT"), RELIGIOUS("RELIGIOUS"),
		RELIGIOUS_ORGANIZATIONS("RELIGIOUS_ORGANIZATIONS"), REMITTANCE("REMITTANCE"),
		RENTAL_PROPERTY_MANAGEMENT("RENTAL_PROPERTY_MANAGEMENT"), RESIDENTIAL("RESIDENTIAL"), RETAIL("RETAIL"),
		RETAIL_FINE_JEWELRY_AND_WATCHES("RETAIL_FINE_JEWELRY_AND_WATCHES"),
		REUPHOLSTERY_AND_FURNITURE_REPAIR("REUPHOLSTERY_AND_FURNITURE_REPAIR"), RINGS("RINGS"),
		ROOFING_SIDING_SHEET_METAL("ROOFING_SIDING_SHEET_METAL"), RUGS_AND_CARPETS("RUGS_AND_CARPETS"),
		SCHOOLS_AND_COLLEGES("SCHOOLS_AND_COLLEGES"), SCIENCE_FICTION("SCIENCE_FICTION"), SCRAPBOOKING("SCRAPBOOKING"),
		SCULPTURES("SCULPTURES"), SECURITIES_BROKERS_AND_DEALERS("SECURITIES_BROKERS_AND_DEALERS"),
		SECURITY_AND_SURVEILLANCE("SECURITY_AND_SURVEILLANCE"),
		SECURITY_AND_SURVEILLANCE_EQUIPMENT("SECURITY_AND_SURVEILLANCE_EQUIPMENT"),
		SECURITY_BROKERS_AND_DEALERS("SECURITY_BROKERS_AND_DEALERS"), SEMINARS("SEMINARS"),
		SERVICE_STATIONS("SERVICE_STATIONS"), SERVICES("SERVICES"),
		SEWING_NEEDLEWORK_FABRIC_AND_PIECE_GOODS_STORES("SEWING_NEEDLEWORK_FABRIC_AND_PIECE_GOODS_STORES"),
		SHIPPING_AND_PACKING("SHIPPING_AND_PACKING"), SHOE_REPAIR_HAT_CLEANING("SHOE_REPAIR_HAT_CLEANING"),
		SHOE_STORES("SHOE_STORES"), SHOES("SHOES"), SNOWMOBILE_DEALERS("SNOWMOBILE_DEALERS"), SOFTWARE("SOFTWARE"),
		SPECIALTY_AND_MISC_FOOD_STORES("SPECIALTY_AND_MISC._FOOD_STORES"),
		SPECIALTY_CLEANING_POLISHING_AND_SANITATION_PREPARATIONS(
				"SPECIALTY_CLEANING_POLISHING_AND_SANITATION_PREPARATIONS"),
		SPECIALTY_OR_RARE_PETS("SPECIALTY_OR_RARE_PETS"), SPORT_GAMES_AND_TOYS("SPORT_GAMES_AND_TOYS"),
		SPORTING_AND_RECREATIONAL_CAMPS("SPORTING_AND_RECREATIONAL_CAMPS"), SPORTING_GOODS("SPORTING_GOODS"),
		SPORTS_AND_OUTDOORS("SPORTS_AND_OUTDOORS"), SPORTS_AND_RECREATION("SPORTS_AND_RECREATION"),
		STAMP_AND_COIN("STAMP_AND_COIN"),
		STATIONARY_PRINTING_AND_WRITING_PAPER("STATIONARY_PRINTING_AND_WRITING_PAPER"),
		STENOGRAPHIC_AND_SECRETARIAL_SUPPORT_SERVICES("STENOGRAPHIC_AND_SECRETARIAL_SUPPORT_SERVICES"),
		STOCKS_BONDS_SECURITIES_AND_RELATED_CERTIFICATES("STOCKS_BONDS_SECURITIES_AND_RELATED_CERTIFICATES"),
		STORED_VALUE_CARDS("STORED_VALUE_CARDS"), SUPPLIES("SUPPLIES"), SUPPLIES_AND_TOYS("SUPPLIES_AND_TOYS"),
		SURVEILLANCE_EQUIPMENT("SURVEILLANCE_EQUIPMENT"), SWIMMING_POOLS_AND_SPAS("SWIMMING_POOLS_AND_SPAS"),
		SWIMMING_POOLS_SALES_SUPPLIES_SERVICES("SWIMMING_POOLS_SALES_SUPPLIES_SERVICES"),
		TAILORS_AND_ALTERATIONS("TAILORS_AND_ALTERATIONS"), TAX_PAYMENTS("TAX_PAYMENTS"),
		TAX_PAYMENTS_GOVERNMENT_AGENCIES("TAX_PAYMENTS_GOVERNMENT_AGENCIES"),
		TAXICABS_AND_LIMOUSINES("TAXICABS_AND_LIMOUSINES"), TELECOMMUNICATION_SERVICES("TELECOMMUNICATION_SERVICES"),
		TELEPHONE_CARDS("TELEPHONE_CARDS"), TELEPHONE_EQUIPMENT("TELEPHONE_EQUIPMENT"),
		TELEPHONE_SERVICES("TELEPHONE_SERVICES"), THEATER("THEATER"),
		TIRE_RETREADING_AND_REPAIR("TIRE_RETREADING_AND_REPAIR"), TOLL_OR_BRIDGE_FEES("TOLL_OR_BRIDGE_FEES"),
		TOOLS_AND_EQUIPMENT("TOOLS_AND_EQUIPMENT"),
		TOURIST_ATTRACTIONS_AND_EXHIBITS("TOURIST_ATTRACTIONS_AND_EXHIBITS"), TOWING_SERVICE("TOWING_SERVICE"),
		TOYS_AND_GAMES("TOYS_AND_GAMES"), TRADE_AND_VOCATIONAL_SCHOOLS("TRADE_AND_VOCATIONAL_SCHOOLS"),
		TRADEMARK_INFRINGEMENT("TRADEMARK_INFRINGEMENT"),
		TRAILER_PARKS_AND_CAMPGROUNDS("TRAILER_PARKS_AND_CAMPGROUNDS"), TRAINING_SERVICES("TRAINING_SERVICES"),
		TRANSPORTATION_SERVICES("TRANSPORTATION_SERVICES"), TRAVEL("TRAVEL"),
		TRUCK_AND_UTILITY_TRAILER_RENTALS("TRUCK_AND_UTILITY_TRAILER_RENTALS"), TRUCK_STOP("TRUCK_STOP"),
		TYPESETTING_PLATE_MAKING_AND_RELATED_SERVICES("TYPESETTING_PLATE_MAKING_AND_RELATED_SERVICES"),
		USED_MERCHANDISE_AND_SECONDHAND_STORES("USED_MERCHANDISE_AND_SECONDHAND_STORES"),
		USED_PARTS_MOTOR_VEHICLE("USED_PARTS_MOTOR_VEHICLE"), UTILITIES("UTILITIES"),
		UTILITIES_ELECTRIC_GAS_WATER_SANITARY("UTILITIES_ELECTRIC_GAS_WATER_SANITARY"),
		VARIETY_STORES("VARIETY_STORES"), VEHICLE_SALES("VEHICLE_SALES"),
		VEHICLE_SERVICE_AND_ACCESSORIES("VEHICLE_SERVICE_AND_ACCESSORIES"), VIDEO_EQUIPMENT("VIDEO_EQUIPMENT"),
		VIDEO_GAME_ARCADES_ESTABLISH("VIDEO_GAME_ARCADES_ESTABLISH"),
		VIDEO_GAMES_AND_SYSTEMS("VIDEO_GAMES_AND_SYSTEMS"), VIDEO_TAPE_RENTAL_STORES("VIDEO_TAPE_RENTAL_STORES"),
		VINTAGE_AND_COLLECTIBLE_VEHICLES("VINTAGE_AND_COLLECTIBLE_VEHICLES"),
		VINTAGE_AND_COLLECTIBLES("VINTAGE_AND_COLLECTIBLES"), VITAMINS_AND_SUPPLEMENTS("VITAMINS_AND_SUPPLEMENTS"),
		VOCATIONAL_AND_TRADE_SCHOOLS("VOCATIONAL_AND_TRADE_SCHOOLS"),
		WATCH_CLOCK_AND_JEWELRY_REPAIR("WATCH_CLOCK_AND_JEWELRY_REPAIR"),
		WEB_HOSTING_AND_DESIGN("WEB_HOSTING_AND_DESIGN"), WELDING_REPAIR("WELDING_REPAIR"),
		WHOLESALE_CLUBS("WHOLESALE_CLUBS"), WHOLESALE_FLORIST_SUPPLIERS("WHOLESALE_FLORIST_SUPPLIERS"),
		WHOLESALE_PRESCRIPTION_DRUGS("WHOLESALE_PRESCRIPTION_DRUGS"), WILDLIFE_PRODUCTS("WILDLIFE_PRODUCTS"),
		WIRE_TRANSFER("WIRE_TRANSFER"), WIRE_TRANSFER_AND_MONEY_ORDER("WIRE_TRANSFER_AND_MONEY_ORDER"),
		WOMEN_ACCESSORY_SPECIALITY("WOMEN_ACCESSORY_SPECIALITY"), WOMEN_CLOTHING("WOMEN_CLOTHING");

		private String value;

		private Category(String value) {
			this.value = value;
		}

		public String toString() {
			return value;
		}
	}

	public static enum Type {

		PHYSICAL("PHYSICAL"), DIGITAL("DIGITAL"), SERVICE("SERVICE");

		private String value;

		private Type(String value) {
			this.value = value;
		}

		public String toString() {
			return value;
		}
	}

	public ProductType() {
		super(new Product());
	}

	public java.lang.reflect.Type getListType() {
		// TODO Auto-generated method stub
		return new TypeToken<List<Product>>() {
		}.getType();
	}

	public Class<Product> getType() {
		// TODO Auto-generated method stub
		return Product.class;
	}
}
