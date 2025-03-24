import "../index.css";
import { useNavigate } from "react-router-dom";

const HeroSection = () => {
  const navigate = useNavigate();
  const handleButtonClick = () => {
    navigate("/cars");
  };
  return (
    <section
      className="hero-section relative p-6 lg:py-100 bg-[#F1F3FF]"
      id="hero-section"
    >
      <div className="container max-w-6xl mx-auto">
        <div className="lg:flex">
          <div className="mb-[200px] lg:mb-0">
            <p className="font-bold text-4xl max-w-[568px] mb-5">
              Sewa & Rental Mobil Terbaik di kawasan Bintaro dan sekitarnya
            </p>
            <p className="text-sm font-light max-w-[463px] mb-5">
              Selamat datang di Binar Car Rental. Kami menyediakan mobil
              kualitas terbaik dengan harga terjangkau. Selalu siap melayani
              kebutuhanmu untuk sewa mobil selama 24 jam.
            </p>
            <button onClick={handleButtonClick} className="btn-green">
              Mulai Sewa Mobil
            </button>
          </div>
          <img
            src="./images/img_car.png"
            alt="car"
            className="block absolute right-0 bottom-0 lg:block"
            style={{ width: "50%" }}
          />
          <img
            src="./images/img_car.png"
            alt="car"
            className="hidden lg:hidden sm:block absolute right-0 bottom-0"
            style={{ width: "60%" }}
          />
          <img
            src="./images/img_car.png"
            alt="car"
            className="hidden sm:hidden mobile:block absolute right-0 bottom-0"
            style={{ width: "70%" }}
          />
          <img
            src="./images/img_car.png"
            alt="car"
            className="block lg:hidden absolute right-0 bottom-0"
            style={{ width: "90%" }}
          />
        </div>
      </div>
    </section>
  );
};

export default HeroSection;
